package com.shine.logger.jlog;

import android.util.Log;
import com.shine.logger.JLog;
import com.shine.logger.Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @desc:
 * @author: jiangcy
 * @date: 16-8-23
 * @time: 上午10:10
 */
public class JsonLog {
  public static void printJson(String tag, String msg, String headString) {

    String message;

    try {
      if (msg.startsWith("{")) {
        JSONObject jsonObject = new JSONObject(msg);
        message = jsonObject.toString(JLog.JSON_INDENT);
      } else if (msg.startsWith("[")) {
        JSONArray jsonArray = new JSONArray(msg);
        message = jsonArray.toString(JLog.JSON_INDENT);
      } else {
        message = msg;
      }
    } catch (JSONException e) {
      message = msg;
    }

    Util.printLine(tag, true);
    message = headString + JLog.LINE_SEPARATOR + message;
    String[] lines = message.split(JLog.LINE_SEPARATOR);
    for (String line : lines) {
      Log.d(tag, "║ " + line);
    }
    Util.printLine(tag, false);
  }
}
