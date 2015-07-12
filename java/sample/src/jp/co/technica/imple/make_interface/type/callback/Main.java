package jp.co.technica.imple.make_interface.type.callback;

public class Main {

    public static void main(String[] args) {

        Button okBtn = new Button();
        okBtn.setOnClickCallback(new Button.OnClickCallback() {
            @Override
            public void onClick() {
                System.out.println("OK button was clicked .");
            }
        });

        Button ngBtn = new Button();
        ngBtn.setOnClickCallback(new Button.OnClickCallback() {
            @Override
            public void onClick() {
                System.out.println("NG button was clicked .");
            }
        });

        Button cancelBtn = new Button();

        User user = new User();
        user.onClickButton(okBtn);
        user.onClickButton(ngBtn);
        user.onClickButton(cancelBtn);
    }

}
