package fax.play;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.InputStream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ProtoParserTest {

   @ParameterizedTest
   @ValueSource(strings = {"proto2", "proto3"})
   public void proto3(String syntaxType) throws Exception {
      try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(syntaxType + "/simple.proto")) {
         ProtoParser parser = new ProtoParser(is);
         ASTInput input = parser.Input();
         assertThat(input.jjtGetNumChildren()).isEqualTo(2);

         Node syntax = input.jjtGetChild(0);
         assertThat(syntax).isInstanceOf(ASTSyntaxPart.class);
         assertThat(syntax.jjtGetNumChildren()).isEqualTo(1);

         Node syntaxValue = syntax.jjtGetChild(0);
         assertThat(syntaxValue).isInstanceOf(ASTCStringPart.class);
         assertThat(((SimpleNode) syntaxValue).jjtGetValue().toString()).isEqualTo("\"" + syntaxType + "\"");

         Node message = input.jjtGetChild(1);
         assertThat(message).isInstanceOf(ASTMessagePart.class);
      }
   }
}
