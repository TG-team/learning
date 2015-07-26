package jp.co.technica.imple.make_interface.select;

import jp.co.technica.imple.make_interface.select.process.ProgressListener;
import jp.co.technica.imple.make_interface.select.process.Transfer;
import jp.co.technica.imple.make_interface.select.process.Transfer.State;
import jp.co.technica.imple.make_interface.select.process.download.Download;

public class Main {

    public static void main(String[] args) {

        executeDownload();

        executeUpload();

    }

    private static void executeUpload() {
        Transfer download = new Download();
        download.addProgressCallback(new ProgressListener() {
            @Override
            public void onProgress(State state, int progress) {
                switch (state) {
                    case Waiting:
                        System.out.println("アップロードを開始します。");
                        break;
                    case InProgress:
                        System.out.println("アップロード中 : " + progress + "%");
                        break;
                    case Completed:
                        System.out.println("アップロードが完了しました。");
                        break;
                    case Canceled:
                        System.out.println("アップロードがキャンセルされました。");
                        break;
                    case Failed:
                        System.out.println("アップロードが失敗しました。");
                        break;
                    default:
                        break;
                }
            }
        });
        download.execute();
    }

    private static void executeDownload() {
        Transfer download = new Download();
        download.addProgressCallback(new ProgressListener() {
            @Override
            public void onProgress(State state, int progress) {
                switch (state) {
                    case Waiting:
                        System.out.println("ダウンロードを開始します。");
                        break;
                    case InProgress:
                        System.out.println("ダウンロード中 : " + progress + "%");
                        break;
                    case Completed:
                        System.out.println("ダウンロードが完了しました。");
                        break;
                    case Canceled:
                        System.out.println("ダウンロードがキャンセルされました。");
                        break;
                    case Failed:
                        System.out.println("ダウンロードが失敗しました。");
                        break;
                    default:
                        break;
                }
            }
        });
        download.execute();
    }
}
