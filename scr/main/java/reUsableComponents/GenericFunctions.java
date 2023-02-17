package reUsableComponents;

import java.sql.Timestamp;

public class GenericFunctions {

public long getTimeStamp() {
Timestamp timestamp = new Timestamp(System.currentTimeMillis());
return timestamp.getTime();
}

}
