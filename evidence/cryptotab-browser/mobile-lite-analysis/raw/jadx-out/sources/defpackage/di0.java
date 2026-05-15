package defpackage;

import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.FragmentManager$LaunchedFragmentInfo;
import androidx.fragment.app.n;
import androidx.fragment.app.s;
import androidx.fragment.app.v;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class di0 implements k4 {
    public final /* synthetic */ int a;
    public final /* synthetic */ s b;

    public /* synthetic */ di0(s sVar, int i) {
        this.a = i;
        this.b = sVar;
    }

    @Override // defpackage.k4
    public final void a(Object obj) {
        switch (this.a) {
            case 0:
                Map map = (Map) obj;
                String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
                }
                s sVar = this.b;
                FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo = (FragmentManager$LaunchedFragmentInfo) sVar.F.pollFirst();
                if (fragmentManager$LaunchedFragmentInfo == null) {
                    Log.w("FragmentManager", "No permissions were requested for " + this);
                } else {
                    v vVar = sVar.c;
                    String str = fragmentManager$LaunchedFragmentInfo.t;
                    n nVarC = vVar.c(str);
                    if (nVarC == null) {
                        Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
                    } else {
                        nVarC.onRequestPermissionsResult(fragmentManager$LaunchedFragmentInfo.u, strArr, iArr);
                    }
                }
                break;
            case 1:
                ActivityResult activityResult = (ActivityResult) obj;
                s sVar2 = this.b;
                FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo2 = (FragmentManager$LaunchedFragmentInfo) sVar2.F.pollLast();
                if (fragmentManager$LaunchedFragmentInfo2 == null) {
                    Log.w("FragmentManager", "No Activities were started for result for " + this);
                } else {
                    v vVar2 = sVar2.c;
                    String str2 = fragmentManager$LaunchedFragmentInfo2.t;
                    n nVarC2 = vVar2.c(str2);
                    if (nVarC2 == null) {
                        Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str2);
                    } else {
                        nVarC2.onActivityResult(fragmentManager$LaunchedFragmentInfo2.u, activityResult.t, activityResult.u);
                    }
                }
                break;
            default:
                ActivityResult activityResult2 = (ActivityResult) obj;
                s sVar3 = this.b;
                FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo3 = (FragmentManager$LaunchedFragmentInfo) sVar3.F.pollFirst();
                if (fragmentManager$LaunchedFragmentInfo3 == null) {
                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                } else {
                    v vVar3 = sVar3.c;
                    String str3 = fragmentManager$LaunchedFragmentInfo3.t;
                    n nVarC3 = vVar3.c(str3);
                    if (nVarC3 == null) {
                        Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str3);
                    } else {
                        nVarC3.onActivityResult(fragmentManager$LaunchedFragmentInfo3.u, activityResult2.t, activityResult2.u);
                    }
                }
                break;
        }
    }
}
