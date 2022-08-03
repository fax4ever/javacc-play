package fax.play;

import java.io.InputStream;

import org.junit.jupiter.api.Test;

public class ProtoParserTest {

   @Test
   public void test() throws Exception {
      try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("simple.proto")) {
         ProtoParser parser = new ProtoParser(is);
         parser.Input();
      }
   }
}
