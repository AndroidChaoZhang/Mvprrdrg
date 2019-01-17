package democoolwidget.zc.com.mvprrdrg.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class DialogUtil {
    public static void alertVersionDialog (Context context,String versionContent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("检测网络状态!");
        builder.setMessage(versionContent);
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }
}
