package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BC {
    public static final List S0;
    public static final List T0;
    public static final HashMap U0;
    public static final C0587eW0 V0;
    public static final C0587eW0 W0;
    public static final C0587eW0 X0;
    public static final C0587eW0 Y0;
    public static final C0587eW0 Z0;
    public static final C0587eW0 a1;
    public static final C0587eW0 b1;
    public static final C0587eW0 c1;
    public static final C0587eW0 d1;
    public static final C0587eW0 e1;
    public static final C0587eW0 f1;
    public static final C0587eW0 g1;
    public static final C0587eW0 h1;
    public static final C0587eW0 i1;
    public static final C0587eW0 j1;
    public static final C0587eW0 k1;
    public static final C0587eW0 l1;
    public static final C0587eW0 m1;
    public static final C0587eW0 n1;
    public static final C0587eW0 o1;
    public static final C0587eW0 p1;
    public static final C0478cW0 q1;
    public static final C0478cW0 r1;
    public static final C0478cW0 s1;
    public static final C0478cW0 t1;
    public static final C0478cW0 u1;
    public static final fW0 v1;
    public static final fW0 w1;
    public static final fW0 x1;
    public static final C0478cW0 y1;
    public static final C1298pw a = new C1298pw("AccountReauthenticationRecentTimeWindow", true);
    public static final C1298pw b = new C1298pw("AndroidAppIntegration", false);
    public static final C1298pw c = new C1298pw("AndroidElegantTextHeight", false);
    public static final C1298pw d = new C1298pw("AndroidGoogleSansText", true);
    public static final C1298pw e = new C1298pw("AndroidHubFloatingActionButton", false);
    public static final C1298pw f = new C1298pw("AndroidHubV2", false);
    public static final C1298pw g = new C1298pw("AndroidTabGroupStableIds", true);
    public static final C1298pw h = new C1298pw("AppSpecificHistory", false);
    public static final C1298pw i = new C1298pw("ArchiveTabService", false);
    public static final C1298pw j = new C1298pw("AsyncNotificationManager", false);
    public static final C1298pw k = new C1298pw("BackGestureActivityTabProvider", false);
    public static final C1298pw l = new C1298pw("BackGestureMoveToBackDuringStartup", true);
    public static final C1298pw m = new C1298pw("BackGestureRefactorAndroid", true);
    public static final C1298pw n = new C1298pw("BackToHomeAnimation", true);
    public static final C1298pw o = new C1298pw("BlockIntentsWhileLocked", false);
    public static final C1298pw p = new C1298pw("CCTAuthView", false);
    public static final C1298pw q = new C1298pw("CCTAutoTranslate", true);
    public static final C1298pw r = new C1298pw("CCTFeatureUsage", false);
    public static final C1298pw s = new C1298pw("CCTEphemeralMode", false);
    public static final C1298pw t = new C1298pw("CCTIncognitoAvailableToThirdParty", false);
    public static final C1298pw u = new C1298pw("CCTIntentFeatureOverrides", true);
    public static final C1298pw v = new C1298pw("CCTMinimized", true);
    public static final C1298pw w = new C1298pw("CCTPageInsightsHub", true);
    public static final C1298pw x = new C1298pw("CCTNavigationalPrefetch", false);
    public static final C1298pw y = new C1298pw("CCTGoogleBottomBar", false);
    public static final C1298pw z = new C1298pw("CCTGoogleBottomBarVariantLayouts", false);
    public static final C1298pw A = new C1298pw("CCTResizableForThirdParties", true);
    public static final C1298pw B = new C1298pw("CCTRevampedBranding", false);
    public static final C1298pw C = new C1298pw("CCTNestedSecurityIcon", false);
    public static final C1298pw D = new C1298pw("CCTTabModalDialog", true);
    public static final C1298pw E = new C1298pw("CollectAndroidFrameTimelineMetrics", false);
    public static final C1298pw F = new C1298pw("CommandLineOnNonRooted", false);
    public static final C1298pw G = new C1298pw("DelayTempStripRemoval", false);
    public static final C1298pw H = new C1298pw("DragDropIntoOmnibox", false);
    public static final C1298pw I = new C1298pw("DownloadsMigrateToJobsAPI", false);

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final C1298pw f0J = new C1298pw("DrawEdgeToEdge", false);
    public static final C1298pw K = new C1298pw("DrawKeyNativeEdgeToEdge", false);
    public static final C1298pw L = new C1298pw("DrawNativeEdgeToEdge", false);
    public static final C1298pw M = new C1298pw("DrawWebEdgeToEdge", false);
    public static final C1298pw N = new C1298pw("EdgeToEdgeBottomChin", false);
    public static final C1298pw O = new C1298pw("EducationalTipModule", false);
    public static final C1298pw P = new C1298pw("ExperimentsForAgsa", true);
    public static final C1298pw Q = new C1298pw("FeedLoadingPlaceholder", false);
    public static final C1298pw R = new C1298pw("ForceListTabSwitcher", false);
    public static final C1298pw S = new C1298pw("FriendlierSafeBrowsingSettingsEnhancedProtection", false);
    public static final C1298pw T = new C1298pw("FriendlierSafeBrowsingSettingsStandardProtection", false);
    public static final C1298pw U = new C1298pw("FullscreenInsetsApiMigration", false);
    public static final C1298pw V = new C1298pw("FullscreenInsetsApiMigrationOnAutomotive", true);
    public static final C1298pw W = new C1298pw("GcmNativeBackgroundTask", false);
    public static final C1298pw X = new C1298pw("IncognitoReauthenticationForAndroid", true);
    public static final C1298pw Y = new C1298pw("LogoPolish", true);
    public static final C1298pw Z = new C1298pw("LogoPolishAnimationKillSwitch", true);
    public static final C1298pw a0 = new C1298pw("MagicStackAndroid", true);
    public static final C1298pw b0 = new C1298pw("MostVisitedTilesSelectExistingTab", false);
    public static final C1298pw c0 = new C1298pw("MultiInstanceApplicationStatusCleanup", false);
    public static final C1298pw d0 = new C1298pw("NavBarColorMatchesTabBackground", false);
    public static final C1298pw e0 = new C1298pw("NewTabPageAndroidTriggerForPrerender2", false);
    public static final C1298pw f0 = new C1298pw("PriceChangeModule", true);
    public static final C1298pw g0 = new C1298pw("PriceInsights", false);
    public static final C1298pw h0 = new C1298pw("PrivacyGuideAndroid3", false);
    public static final C1298pw i0 = new C1298pw("PrivacyGuidePreloadAndroid", false);
    public static final C1298pw j0 = new C1298pw("OptimizationGuidePushNotifications", false);
    public static final C1298pw k0 = new C1298pw("PaintPreviewDemo", false);
    public static final C1298pw l0 = new C1298pw("PrefetchBrowserInitiatedTriggers", false);
    public static final C1298pw m0 = new C1298pw("QueryTiles", false);
    public static final C1298pw n0 = new C1298pw("RedirectExplicitCTAIntentsToExistingActivity", true);
    public static final C1298pw o0 = new C1298pw("SafeBrowsingCallNewGmsApiOnStartup", false);
    public static final C1298pw p0 = new C1298pw("SafetyHub", false);
    public static final C1298pw q0 = new C1298pw("SafetyHubMagicStack", false);
    public static final C1298pw r0 = new C1298pw("SearchEngineChoice", false);
    public static final C1298pw s0 = new C1298pw("SearchInCCT", false);
    public static final C1298pw t0 = new C1298pw("SmallerTabStripTitleLimit", true);
    public static final C1298pw u0 = new C1298pw("StartSurfaceReturnTime", true);
    public static final C1298pw v0 = new C1298pw("SurfacePolish", true);
    public static final C1298pw w0 = new C1298pw("SurfacePolishForToolbarKillSwitch", true);
    public static final C1298pw x0 = new C1298pw("TabDragDropAndroid", false);
    public static final C1298pw y0 = new C1298pw("TabGroupCreationDialogAndroid", false);
    public static final C1298pw z0 = new C1298pw("TabGroupPaneAndroid", false);
    public static final C1298pw A0 = new C1298pw("TabGroupParityAndroid", false);
    public static final C1298pw B0 = new C1298pw("TabResumptionModuleAndroid", false);
    public static final C1298pw C0 = new C1298pw("TabStateFlatBuffer", false);
    public static final C1298pw D0 = new C1298pw("TabStripLayoutOptimization", true);
    public static final C1298pw E0 = new C1298pw("TabStripStartupRefactoring", true);
    public static final C1298pw F0 = new C1298pw("TabletToolbarReordering", false);
    public static final C1298pw G0 = new C1298pw("TabStripGroupCollapseAndroid", false);
    public static final C1298pw H0 = new C1298pw("TabStripGroupIndicatorsAndroid", false);
    public static final C1298pw I0 = new C1298pw("TabWindowManagerIndexReassignmentActivityFinishing", true);
    public static final C1298pw J0 = new C1298pw("TabWindowManagerIndexReassignmentActivityInSameTask", true);
    public static final C1298pw K0 = new C1298pw("TabWindowManagerIndexReassignmentActivityNotInAppTasks", true);
    public static final C1298pw L0 = new C1298pw("TabWindowManagerReportIndicesMismatch", true);
    public static final C1298pw M0 = new C1298pw("TestDefaultDisabled", false);
    public static final C1298pw N0 = new C1298pw("TestDefaultEnabled", true);
    public static final C1298pw O0 = new C1298pw("UseChimeAndroidSdk", false);
    public static final C1298pw P0 = new C1298pw("UseLibunwindstackNativeUnwinderAndroid", true);
    public static final C1298pw Q0 = new C1298pw("VerticalAutomotiveBackButtonToolbar", true);
    public static final C1298pw R0 = new C1298pw("WebApkMinShellVersion", true);

    static {
        C1298pw[] c1298pwArr = {a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, s, r, t, u, v, x, w, y, z, A, B, C, D, E, F, G, H, I, f0J, K, L, M, N, O, Q, R, S, T, U, V, W, X, Y, Z, a0, b0, c0, d0, e0, f0, g0, h0, i0, j0, k0, l0, m0, n0, o0, p0, q0, r0, s0, t0, u0, v0, w0, x0, y0, z0, A0, B0, C0, G0, H0, D0, E0, F0, I0, J0, K0, L0, O0, P0, Q0, R0};
        ArrayList arrayList = new ArrayList(93);
        for (int i2 = 0; i2 < 93; i2++) {
            C1298pw c1298pw = c1298pwArr[i2];
            Objects.requireNonNull(c1298pw);
            arrayList.add(c1298pw);
        }
        S0 = Collections.unmodifiableList(arrayList);
        Object[] objArr = {P};
        ArrayList arrayList2 = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList2.add(obj);
        T0 = Collections.unmodifiableList(arrayList2);
        Object[] objArr2 = {M0, N0};
        ArrayList arrayList3 = new ArrayList(2);
        for (int i3 = 0; i3 < 2; i3++) {
            Object obj2 = objArr2[i3];
            Objects.requireNonNull(obj2);
            arrayList3.add(obj2);
        }
        Object[] objArr3 = {S0, T0, Collections.unmodifiableList(arrayList3)};
        ArrayList arrayList4 = new ArrayList(3);
        for (int i4 = 0; i4 < 3; i4++) {
            Object obj3 = objArr3[i4];
            Objects.requireNonNull(obj3);
            arrayList4.add(obj3);
        }
        List listUnmodifiableList = Collections.unmodifiableList(arrayList4);
        HashMap map = new HashMap();
        Iterator it = listUnmodifiableList.iterator();
        while (it.hasNext()) {
            for (C1298pw c1298pw2 : (List) it.next()) {
                map.put(c1298pw2.b, c1298pw2);
            }
        }
        U0 = map;
        V0 = c("AdaptiveButtonInTopToolbarCustomizationV2", false);
        W0 = c("AndroidImprovedBookmarks", false);
        C0587eW0 c0587eW0C = c("AndroidTabDeclutter", false);
        X0 = c0587eW0C;
        Y0 = c("AndroidTabDeclutterArchiveAllButActiveTab", false);
        Z0 = c("AndroidTabDeclutterRescueKillswitch", true);
        C0587eW0 c0587eW0C2 = c("BottomBrowserControlsRefactor", true);
        a1 = c0587eW0C2;
        b1 = c("BrowserControlsEarlyResize", false);
        C0587eW0 c0587eW0C3 = c("GtsCloseTabAnimation", false);
        c1 = c0587eW0C3;
        d1 = c("IncognitoScreenshot", false);
        e1 = c("AndroidNoVisibleHintForDifferentTLD", true);
        c("CCTPageInsightsHubPeek", true);
        c("CCTPageInsightsHubBetterScroll", false);
        f1 = c("QuickDeleteForAndroid", true);
        g1 = c("QuickDeleteAndroidFollowup", false);
        h1 = c("QuickDeleteAndroidSurvey", false);
        i1 = c("ReadAloudTapToSeek", false);
        j1 = c("ReaderModeInCCT", false);
        k1 = c("RecordSuppressionMetrics", true);
        C0587eW0 c0587eW0C4 = c("SuppressToolbarCaptures", false);
        l1 = c0587eW0C4;
        m1 = c("SuppressToolbarCapturesAtGestureEnd", false);
        n1 = c("AndroidToolbarScrollAblation", false);
        o1 = c("AndroidBrowserControlsInViz", false);
        p1 = c("VoiceSearchAudioCapturePolicy", false);
        q1 = c0587eW0C3.b("close_all_custom_animation", false);
        r1 = c0587eW0C3.b("close_all_quick_delete_animation", false);
        s1 = c0587eW0C3.b("rearrange_standard_easing", false);
        t1 = c0587eW0C3.b("skip_removal_delay", false);
        u1 = c0587eW0C4.b("block_for_fullscreen", false);
        String str = c0587eW0C.b;
        AbstractC0080Gb0 abstractC0080Gb0 = c0587eW0C.a;
        v1 = new fW0(abstractC0080Gb0, str, "android_tab_declutter_archive_time_delta_hours", 168);
        w1 = new fW0(abstractC0080Gb0, str, "android_tab_declutter_auto_delete_time_delta_hours", 1440);
        x1 = new fW0(abstractC0080Gb0, str, "android_tab_declutter_interval_time_delta_hours", 168);
        y1 = c0587eW0C2.b("disable_bottom_controls_stacker_y_offset", true);
    }

    public static C0179Ot a(String str, String str2, boolean z2) {
        return new C0179Ot(CC.b, str, str2, z2);
    }

    public static C1180ny0 b(int i2, String str, String str2) {
        return new C1180ny0(CC.b, str, str2, i2);
    }

    public static C0587eW0 c(String str, boolean z2) {
        return new C0587eW0(CC.b, str, z2);
    }
}
