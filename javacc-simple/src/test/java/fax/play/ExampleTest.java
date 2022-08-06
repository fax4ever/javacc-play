package fax.play;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

public class ExampleTest {

   @Test
   public void legalInput() throws Exception {
      String initialString = "{{{}}}";
      try (InputStream targetStream = new ByteArrayInputStream(initialString.getBytes())) {
         Example example = new Example(targetStream);
         example.Input();
      }
   }

   @Test
   public void illegalInput() throws Exception {
      String initialString = "{{{-}}";
      try (InputStream targetStream = new ByteArrayInputStream(initialString.getBytes())) {
         Example example = new Example(targetStream);

         assertThatThrownBy(() -> example.Input())
               .isInstanceOf(TokenMgrError.class);
      }
   }
}
