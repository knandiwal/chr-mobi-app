package org.apache.cordova.plugin;

import android.util.Log;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.dianping.ba.crm.Mobile.MobileApp;

import cn.jpush.android.api.JPushInterface;

public class PushNotification extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args,
                           CallbackContext callbackContext) throws JSONException {
        if (action.equals("getInfo")) {
            this.getInfo(callbackContext);
            return true;
        }
        return false;
    }

    private void getInfo(CallbackContext callbackContext) {
        String token = MobileApp.getToken();
        String type = "android";
        String appId = "1";

        Log.i("UserToken", token);
        JPushInterface.setAliasAndTags(MobileApp.getInstance(), token,
                null);
        JSONObject json = new JSONObject();
        try {
            json.put("token", token);
            json.put("type", type);
            json.put("appId", appId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callbackContext.success(json);
    }

}