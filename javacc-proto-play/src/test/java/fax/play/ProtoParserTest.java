package fax.play;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.InputStream;

import org.junit.jupiter.api.Test;

public class ProtoParserTest {

   @Test
   public void test() throws Exception {
      try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("proto/simple.proto")) {
         ProtoParser parser = new ProtoParser(is);
         ASTInput input = parser.Input();

         assertThat(input).isNotNull();
      }
   }
}
