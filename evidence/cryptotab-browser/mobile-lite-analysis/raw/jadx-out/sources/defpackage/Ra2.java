package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ra2 {
    public final byte[] a;
    public String b;
    public ArrayList c;

    public Ra2(byte[] bArr) {
        this.a = bArr;
    }

    public static Ra2 a(List list, String str) throws IOException {
        Collections.sort(list, new Qa2());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeUTF(str);
        dataOutputStream.writeInt(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            byte[] bArr = (byte[]) it.next();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
        dataOutputStream.flush();
        return new Ra2(byteArrayOutputStream.toByteArray(), str, list);
    }

    public final void b() throws IOException {
        if (this.b != null) {
            return;
        }
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(this.a));
        this.b = dataInputStream.readUTF();
        int i = dataInputStream.readInt();
        this.c = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = dataInputStream.readInt();
            byte[] bArr = new byte[i3];
            if (dataInputStream.read(bArr) != i3) {
                throw new IllegalStateException("Could not read fingerprint");
            }
            this.c.add(bArr);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Ra2.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.a, ((Ra2) obj).a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public Ra2(byte[] bArr, String str, List list) {
        this.a = bArr;
        this.b = str;
        this.c = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) it.next();
            this.c.add(Arrays.copyOf(bArr2, bArr2.length));
        }
    }
}
