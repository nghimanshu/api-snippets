// Install the Java helper library from twilio.com/docs/java/install
import com.twilio.Twilio;
import com.twilio.rest.video.v1.Composition;
import com.twilio.rest.video.v1.Composition.Format;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GridComposition{

  // Find your credentials at twilio.com/console
  public static final String ACCOUNT_SID = "ACXXXX";
  public static final String API_KEY_SID = "SKXXXX";
  public static final String API_KEY_SECRET = "your_api_key_secret";

  public static void main( String[] args ) throws IOException{
      // Initialize the client
      Twilio.init(API_KEY_SID, API_KEY_SECRET, ACCOUNT_SID);

      final String videoLayout =
                          "{"
                        + "   \"grid\": {"
                        + "       \"max_rows\": 1,"
                        + "       \"video_sources\":["
                        + "                 \"RTAAAA\","
                        + "                 \"MTBBBB\","
                        + "                 \"teacher-webcast\""
                        + "          ]"
                        + "    }"
                        + "}";

      Composition composition = Composition.creator()
                  .setRoomSid("RMXXXX")
                  .setVideoLayout(new ObjectMapper().readValue(videoLayout, HashMap.class))
                  .setStatusCallback("http://my.server.org/callbacks")
                  .setFormat(Format.MP4)
                  .create();

      System.out.println("Created composition with SID=" + composition.getSid());
  }
}
