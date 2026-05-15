package defpackage;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

/* JADX INFO: renamed from: tO2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1503tO2 extends TO2 {
    public final C1386rO2 c;
    public boolean d;

    public C1503tO2(C1391rR2 c1391rR2) {
        super(c1391rR2);
        this.c = new C1386rO2(this, this.a.a);
    }

    @Override // defpackage.TO2
    public final boolean j() {
        return false;
    }

    public final SQLiteDatabase k() {
        if (this.d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.d = true;
        return null;
    }

    public final void l() {
        int iDelete;
        C1391rR2 c1391rR2 = this.a;
        g();
        try {
            SQLiteDatabase sQLiteDatabaseK = k();
            if (sQLiteDatabaseK == null || (iDelete = sQLiteDatabaseK.delete("messages", null, null)) <= 0) {
                return;
            }
            WO2 wo2 = c1391rR2.i;
            C1391rR2.k(wo2);
            wo2.n.b(Integer.valueOf(iDelete), "Reset local analytics data. records");
        } catch (SQLiteException e) {
            WO2 wo22 = c1391rR2.i;
            C1391rR2.k(wo22);
            wo22.f.b(e, "Error resetting local analytics data. error");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006f A[PHI: r4
      0x006f: PHI (r4v4 int) = (r4v1 int), (r4v2 int), (r4v1 int) binds: [B:35:0x007f, B:32:0x006d, B:29:0x0066] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m() {
        /*
            r10 = this;
            java.lang.String r0 = "Error deleting app launch break from local database"
            r10.g()
            boolean r1 = r10.d
            if (r1 == 0) goto La
            return
        La:
            rR2 r1 = r10.a
            android.content.Context r2 = r1.a
            java.lang.String r3 = "google_app_measurement_local.db"
            java.io.File r2 = r2.getDatabasePath(r3)
            boolean r2 = r2.exists()
            if (r2 == 0) goto L97
            r2 = 0
            r3 = 5
            r4 = r3
        L1d:
            if (r2 >= r3) goto L8b
            r5 = 1
            r6 = 0
            android.database.sqlite.SQLiteDatabase r6 = r10.k()     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteException -> L2c android.database.sqlite.SQLiteFullException -> L2e android.database.sqlite.SQLiteDatabaseLockedException -> L67
            if (r6 != 0) goto L30
            r10.d = r5     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteException -> L2c android.database.sqlite.SQLiteFullException -> L2e android.database.sqlite.SQLiteDatabaseLockedException -> L67
            return
        L2a:
            r0 = move-exception
            goto L85
        L2c:
            r7 = move-exception
            goto L4d
        L2e:
            r7 = move-exception
            goto L73
        L30:
            r6.beginTransaction()     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteException -> L2c android.database.sqlite.SQLiteFullException -> L2e android.database.sqlite.SQLiteDatabaseLockedException -> L67
            r7 = 3
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteException -> L2c android.database.sqlite.SQLiteFullException -> L2e android.database.sqlite.SQLiteDatabaseLockedException -> L67
            java.lang.String[] r7 = new java.lang.String[]{r7}     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteException -> L2c android.database.sqlite.SQLiteFullException -> L2e android.database.sqlite.SQLiteDatabaseLockedException -> L67
            java.lang.String r8 = "messages"
            java.lang.String r9 = "type == ?"
            r6.delete(r8, r9, r7)     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteException -> L2c android.database.sqlite.SQLiteFullException -> L2e android.database.sqlite.SQLiteDatabaseLockedException -> L67
            r6.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteException -> L2c android.database.sqlite.SQLiteFullException -> L2e android.database.sqlite.SQLiteDatabaseLockedException -> L67
            r6.endTransaction()     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteException -> L2c android.database.sqlite.SQLiteFullException -> L2e android.database.sqlite.SQLiteDatabaseLockedException -> L67
            r6.close()
            return
        L4d:
            if (r6 == 0) goto L58
            boolean r8 = r6.inTransaction()     // Catch: java.lang.Throwable -> L2a
            if (r8 == 0) goto L58
            r6.endTransaction()     // Catch: java.lang.Throwable -> L2a
        L58:
            WO2 r8 = r1.i     // Catch: java.lang.Throwable -> L2a
            defpackage.C1391rR2.k(r8)     // Catch: java.lang.Throwable -> L2a
            CO2 r8 = r8.f     // Catch: java.lang.Throwable -> L2a
            r8.b(r7, r0)     // Catch: java.lang.Throwable -> L2a
            r10.d = r5     // Catch: java.lang.Throwable -> L2a
            if (r6 == 0) goto L82
            goto L6f
        L67:
            long r7 = (long) r4     // Catch: java.lang.Throwable -> L2a
            android.os.SystemClock.sleep(r7)     // Catch: java.lang.Throwable -> L2a
            int r4 = r4 + 20
            if (r6 == 0) goto L82
        L6f:
            r6.close()
            goto L82
        L73:
            WO2 r8 = r1.i     // Catch: java.lang.Throwable -> L2a
            defpackage.C1391rR2.k(r8)     // Catch: java.lang.Throwable -> L2a
            CO2 r8 = r8.f     // Catch: java.lang.Throwable -> L2a
            r8.b(r7, r0)     // Catch: java.lang.Throwable -> L2a
            r10.d = r5     // Catch: java.lang.Throwable -> L2a
            if (r6 == 0) goto L82
            goto L6f
        L82:
            int r2 = r2 + 1
            goto L1d
        L85:
            if (r6 == 0) goto L8a
            r6.close()
        L8a:
            throw r0
        L8b:
            WO2 r0 = r1.i
            defpackage.C1391rR2.k(r0)
            java.lang.String r1 = "Error deleting app launch break from local database in reasonable time"
            CO2 r0 = r0.i
            r0.a(r1)
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1503tO2.m():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e8 A[PHI: r10
      0x00e8: PHI (r10v3 android.database.sqlite.SQLiteDatabase) = (r10v2 android.database.sqlite.SQLiteDatabase), (r10v4 android.database.sqlite.SQLiteDatabase) binds: [B:61:0x00e6, B:77:0x0114] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0124  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n(int r19, byte[] r20) {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1503tO2.n(int, byte[]):boolean");
    }
}
