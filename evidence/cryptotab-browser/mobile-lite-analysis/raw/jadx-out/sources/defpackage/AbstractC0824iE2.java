package defpackage;

import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* JADX INFO: renamed from: iE2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0824iE2 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e0  */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(defpackage.WO2 r16, android.database.sqlite.SQLiteDatabase r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String[] r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC0824iE2.a(WO2, android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    public static void b(WO2 wo2, SQLiteDatabase sQLiteDatabase) {
        if (wo2 == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        boolean readable = file.setReadable(false, false);
        CO2 co2 = wo2.i;
        if (!readable) {
            co2.a("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            co2.a("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            co2.a("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        co2.a("Failed to turn on database write permission for owner");
    }
}
