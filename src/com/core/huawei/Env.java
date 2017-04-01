package com.core.huawei;

import java.util.*;

/**
 * 閿熺粨渚涚郴缁熼敓鏂ゆ嫹閿熷彨浼欐嫹閿熸枻鎷烽敓鏂ゆ嫹鎭敓鏂ゆ嫹
 */ 
public class Env {

  /** 閿熸枻鎷烽敓鐭鎷峰啓閿熸磥銆�*/
  static Map<String, String> config;

  /**
   * 鍙栭敓鏂ゆ嫹閿熸枻鎷烽敓鐭鎷峰啓閿熸磥銆�
   */
  public static Map getConfig() {

    // SP add the GW info
    if (config == null) {
      try {
        config = new HashMap<String, String>();
        //缂冩垵鍙ф稉缁樻簚閻ㄥ嚘P
        config.put("host", "127.0.0.1");
        //鏉╃偞甯寸純鎴濆彠娑撶粯婧�閻ㄥ嫮顏崣锟�
        config.put("port", "8801");
		//閻у妾伴惃鍕瑤閸欏嘲鎮�
        config.put("login-name", "ZCJK_R");
		//鐎电懓绨叉稊瀣閻ㄥ埐ogin-pass
        config.put("login-pass", "ZCJK_R"); 
        //韫囧啳鐑︽穱鈩冧紖閸欐垿锟戒線妫块梾鏃�妞傞梻锟�(閸楁洑缍呴敍姘鳖潡)
        config.put("heartbeat-interval","30" );
        //鏉╃偞甯存稉顓熸焽閺冨爼鍣告潻鐐烘？闂呮梹妞傞梻锟�(閸楁洑缍呴敍姘鳖潡)
        config.put("reconnectInterval", "30");
        //闂囷拷鐟曚線鍣告潻鐐存閿涘矁绻涚紒顓炲絺閸戝搫绺剧捄鍏呬繆閹垱鐥呴張澶嬪复閺�璺哄煂閸濆秴绨查惃鍕嚋閺佸府绱欓崡鏇氱秴閿涙矮閲�)
        config.put("heartbeat-noresponseout", "5");
        //閹垮秳缍旂搾鍛閺冨爼妫�(閸楁洑缍呴敍姘鳖潡)
        config.put("transaction-timeout", "10");
       //椋︼拷	true鐞涖劎銇氱仦鐐扮艾鐠嬪啳鐦悩鑸碉拷渚婄礉閹碉拷閺堝娈戝☉鍫熶紖鐞氼偅澧﹂崡鎷岀翻閸戝搫鍩岀仦蹇撶;false鐞涖劎銇氭稉宥呯潣娴滃氦鐨熺拠鏇犲Ц閹緤绱濋幍锟介張澶屾畱濞戝牊浼呮稉宥堫潶鏉堟挸鍤妴锟�
        config.put("debug", "false");   
      
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    return config;
  }
  
}
