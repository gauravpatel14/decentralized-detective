package defpackage;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.util.Log;
import android.util.Pair;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b9 {
    public static HashSet a(Context context, Set set) {
        Intent intent;
        HashSet hashSet = new HashSet();
        for (ActivityManager.AppTask appTask : ((ActivityManager) context.getSystemService("activity")).getAppTasks()) {
            ActivityManager.RecentTaskInfo recentTaskInfoC = c(appTask);
            if (recentTaskInfoC != null) {
                ActivityManager.RecentTaskInfo recentTaskInfoC2 = c(appTask);
                String className = null;
                if (recentTaskInfoC2 != null && (intent = recentTaskInfoC2.baseIntent) != null) {
                    if (intent.getComponent() != null) {
                        className = intent.getComponent().getClassName();
                    } else {
                        ResolveInfo resolveInfoD = v61.d(intent, 0);
                        if (resolveInfoD != null) {
                            className = resolveInfoD.activityInfo.name;
                        }
                    }
                }
                if (set.contains(className)) {
                    hashSet.add(Pair.create(appTask, recentTaskInfoC));
                }
            }
        }
        return hashSet;
    }

    public static HashSet b(Context context, Set set) {
        HashSet hashSet = new HashSet();
        List<ActivityManager.RecentTaskInfo> recentTasks = ((ActivityManager) context.getSystemService("activity")).getRecentTasks(100, 0);
        if (recentTasks != null) {
            for (ActivityManager.RecentTaskInfo recentTaskInfo : recentTasks) {
                ComponentName component = recentTaskInfo.baseIntent.getComponent();
                if (component != null && set.contains(component.getClassName()) && component.getPackageName().equals(context.getPackageName())) {
                    hashSet.add(recentTaskInfo);
                }
            }
        }
        return hashSet;
    }

    public static ActivityManager.RecentTaskInfo c(ActivityManager.AppTask appTask) {
        try {
            return appTask.getTaskInfo();
        } catch (IllegalArgumentException e) {
            Log.e("DocumentUtilities", "Failed to retrieve task info: ", e);
            return null;
        }
    }
}
