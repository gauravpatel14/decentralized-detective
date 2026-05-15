package org.chromium.ui.permissions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public interface AndroidPermissionDelegate {
    boolean canRequestPermission(String str);

    boolean hasPermission(String str);
}
