package jp.co.technica.imple.make_interface.type.constant;

public interface Rate {

    /**
     * 法定時間内労働時間の割増賃金率
     */
    int PRESCRIBED_TIME = 100;

    /**
     * 法定外労働時間(通常残業)の割増賃金率
     */
    int OVERTIME = 120;

    /**
     * 法定外休日労働時間(深夜残業)の割増賃金率
     */
    int MIDNIGHT_OVERTIME = 150;
}
