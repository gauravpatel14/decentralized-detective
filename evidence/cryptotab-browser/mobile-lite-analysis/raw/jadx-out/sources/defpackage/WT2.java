package defpackage;

import android.util.Pair;
import com.google.android.play.core.splitinstall.internal.zzf;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WT2 {
    public static X509Certificate[][] a(String str) {
        Pair pairA;
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            if (randomAccessFile.length() < 22) {
                pairA = null;
            } else {
                pairA = AbstractC0966kV2.a(randomAccessFile, 0);
                if (pairA == null) {
                    pairA = AbstractC0966kV2.a(randomAccessFile, 65535);
                }
            }
            if (pairA == null) {
                throw new zzf("Not an APK file: ZIP End of Central Directory record not found in file with " + randomAccessFile.length() + " bytes");
            }
            ByteBuffer byteBuffer = (ByteBuffer) pairA.first;
            long jLongValue = ((Long) pairA.second).longValue();
            long j = (-20) + jLongValue;
            if (j >= 0) {
                randomAccessFile.seek(j);
                if (randomAccessFile.readInt() == 1347094023) {
                    throw new zzf("ZIP64 APK not supported");
                }
            }
            AbstractC0966kV2.b(byteBuffer);
            long j2 = ((long) byteBuffer.getInt(byteBuffer.position() + 16)) & 4294967295L;
            if (j2 >= jLongValue) {
                throw new zzf("ZIP Central Directory offset out of range: " + j2 + ". ZIP End of Central Directory offset: " + jLongValue);
            }
            AbstractC0966kV2.b(byteBuffer);
            long j3 = jLongValue;
            if ((((long) byteBuffer.getInt(byteBuffer.position() + 12)) & 4294967295L) + j2 != j3) {
                throw new zzf("ZIP Central Directory is not immediately followed by End of Central Directory");
            }
            if (j2 < 32) {
                throw new zzf("APK too small for APK Signing Block. ZIP Central Directory offset: " + j2);
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferAllocate.order(byteOrder);
            randomAccessFile.seek(j2 - ((long) byteBufferAllocate.capacity()));
            randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
            if (byteBufferAllocate.getLong(8) != 2334950737559900225L || byteBufferAllocate.getLong(16) != 3617552046287187010L) {
                throw new zzf("No APK Signing Block before ZIP Central Directory");
            }
            long j4 = byteBufferAllocate.getLong(0);
            if (j4 < byteBufferAllocate.capacity() || j4 > 2147483639) {
                throw new zzf("APK Signing Block size out of range: " + j4);
            }
            int i = (int) (8 + j4);
            long j5 = j2 - ((long) i);
            if (j5 < 0) {
                throw new zzf("APK Signing Block offset out of range: " + j5);
            }
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i);
            byteBufferAllocate2.order(byteOrder);
            randomAccessFile.seek(j5);
            randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
            long j6 = byteBufferAllocate2.getLong(0);
            if (j6 != j4) {
                throw new zzf("APK Signing Block sizes in header and footer do not match: " + j6 + " vs " + j4);
            }
            Pair pairCreate = Pair.create(byteBufferAllocate2, Long.valueOf(j5));
            ByteBuffer byteBuffer2 = (ByteBuffer) pairCreate.first;
            long jLongValue2 = ((Long) pairCreate.second).longValue();
            if (byteBuffer2.order() != byteOrder) {
                throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
            }
            int iCapacity = byteBuffer2.capacity() - 24;
            if (iCapacity < 8) {
                throw new IllegalArgumentException("end < start: " + iCapacity + " < 8");
            }
            int iCapacity2 = byteBuffer2.capacity();
            if (iCapacity > byteBuffer2.capacity()) {
                throw new IllegalArgumentException("end > capacity: " + iCapacity + " > " + iCapacity2);
            }
            int iLimit = byteBuffer2.limit();
            int iPosition = byteBuffer2.position();
            try {
                byteBuffer2.position(0);
                byteBuffer2.limit(iCapacity);
                byteBuffer2.position(8);
                ByteBuffer byteBufferSlice = byteBuffer2.slice();
                byteBufferSlice.order(byteBuffer2.order());
                byteBuffer2.position(0);
                byteBuffer2.limit(iLimit);
                byteBuffer2.position(iPosition);
                int i2 = 0;
                while (byteBufferSlice.hasRemaining()) {
                    i2++;
                    if (byteBufferSlice.remaining() < 8) {
                        throw new zzf("Insufficient data to read size of APK Signing Block entry #" + i2);
                    }
                    long j7 = byteBufferSlice.getLong();
                    if (j7 < 4 || j7 > 2147483647L) {
                        throw new zzf("APK Signing Block entry #" + i2 + " size out of range: " + j7);
                    }
                    int i3 = (int) j7;
                    int iPosition2 = byteBufferSlice.position() + i3;
                    if (i3 > byteBufferSlice.remaining()) {
                        throw new zzf("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + byteBufferSlice.remaining());
                    }
                    if (byteBufferSlice.getInt() == 1896449818) {
                        X509Certificate[][] x509CertificateArrK = k(randomAccessFile.getChannel(), new C0703gN2(e(i3 - 4, byteBufferSlice), jLongValue2, j2, j3, byteBuffer));
                        randomAccessFile.close();
                        return x509CertificateArrK;
                    }
                    long j8 = j3;
                    byteBufferSlice.position(iPosition2);
                    j3 = j8;
                }
                throw new zzf("No APK Signature Scheme v2 block in APK Signing Block");
            } catch (Throwable th) {
                byteBuffer2.position(0);
                byteBuffer2.limit(iLimit);
                byteBuffer2.position(iPosition);
                throw th;
            }
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int b(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        throw new IllegalArgumentException(AbstractC1214oR1.a(i, "Unknown content digest algorthm: "));
    }

    public static int c(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        switch (i) {
            case 257:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString(i))));
        }
    }

    public static String d(int i) {
        if (i == 1) {
            return "SHA-256";
        }
        if (i == 2) {
            return "SHA-512";
        }
        throw new IllegalArgumentException(AbstractC1214oR1.a(i, "Unknown content digest algorthm: "));
    }

    public static ByteBuffer e(int i, ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int i2 = i + iPosition;
        if (i2 < iPosition || i2 > iLimit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return byteBufferSlice;
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    public static ByteBuffer f(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() < 4) {
            throw new IOException(AbstractC1214oR1.a(byteBuffer.remaining(), "Remaining buffer too short to contain length of length-prefixed field. Remaining: "));
        }
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i <= byteBuffer.remaining()) {
            return e(i, byteBuffer);
        }
        throw new IOException(Vx1.a(i, byteBuffer.remaining(), "Length-prefixed field longer than remaining buffer. Field length: ", ", remaining: "));
    }

    public static void g(int i, byte[] bArr) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >>> 8) & 255);
        bArr[3] = (byte) ((i >>> 16) & 255);
        bArr[4] = (byte) (i >> 24);
    }

    public static byte[] h(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        }
        if (i > byteBuffer.remaining()) {
            throw new IOException(Vx1.a(i, byteBuffer.remaining(), "Underflow while reading length-prefixed value. Length: ", ", available: "));
        }
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static X509Certificate[] i(ByteBuffer byteBuffer, HashMap map, CertificateFactory certificateFactory) throws IOException {
        String str;
        Pair pairCreate;
        ByteBuffer byteBufferF = f(byteBuffer);
        ByteBuffer byteBufferF2 = f(byteBuffer);
        byte[] bArrH = h(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrH2 = null;
        int i = -1;
        byte[] bArrH3 = null;
        int i2 = 0;
        while (byteBufferF2.hasRemaining()) {
            i2++;
            try {
                ByteBuffer byteBufferF3 = f(byteBufferF2);
                if (byteBufferF3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i3 = byteBufferF3.getInt();
                arrayList.add(Integer.valueOf(i3));
                if (i3 != 513 && i3 != 514 && i3 != 769) {
                    switch (i3) {
                        case 257:
                        case 258:
                        case 259:
                        case 260:
                            break;
                        default:
                            continue;
                    }
                }
                if (i != -1) {
                    int iC = c(i3);
                    int iC2 = c(i);
                    if (iC != 1 && iC2 == 1) {
                    }
                }
                bArrH3 = h(byteBufferF3);
                i = i3;
            } catch (IOException e) {
                e = e;
                throw new SecurityException(AbstractC1214oR1.a(i2, "Failed to parse signature record #"), e);
            } catch (BufferUnderflowException e2) {
                e = e2;
                throw new SecurityException(AbstractC1214oR1.a(i2, "Failed to parse signature record #"), e);
            }
        }
        if (i == -1) {
            if (i2 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        if (i == 513 || i == 514) {
            str = "EC";
        } else if (i != 769) {
            switch (i) {
                case 257:
                case 258:
                case 259:
                case 260:
                    str = "RSA";
                    break;
                default:
                    throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString(i))));
            }
        } else {
            str = "DSA";
        }
        if (i == 513) {
            pairCreate = Pair.create("SHA256withECDSA", null);
        } else if (i == 514) {
            pairCreate = Pair.create("SHA512withECDSA", null);
        } else if (i != 769) {
            switch (i) {
                case 257:
                    pairCreate = Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                    break;
                case 258:
                    pairCreate = Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                    break;
                case 259:
                    pairCreate = Pair.create("SHA256withRSA", null);
                    break;
                case 260:
                    pairCreate = Pair.create("SHA512withRSA", null);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString(i))));
            }
        } else {
            pairCreate = Pair.create("SHA256withDSA", null);
        }
        String str2 = (String) pairCreate.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pairCreate.second;
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(bArrH));
            Signature signature = Signature.getInstance(str2);
            signature.initVerify(publicKeyGeneratePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(byteBufferF);
            if (!signature.verify(bArrH3)) {
                throw new SecurityException(String.valueOf(str2).concat(" signature did not verify"));
            }
            byteBufferF.clear();
            ByteBuffer byteBufferF4 = f(byteBufferF);
            ArrayList arrayList2 = new ArrayList();
            int i4 = 0;
            while (byteBufferF4.hasRemaining()) {
                i4++;
                try {
                    ByteBuffer byteBufferF5 = f(byteBufferF4);
                    if (byteBufferF5.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i5 = byteBufferF5.getInt();
                    arrayList2.add(Integer.valueOf(i5));
                    if (i5 == i) {
                        bArrH2 = h(byteBufferF5);
                    }
                } catch (IOException e3) {
                    e = e3;
                    throw new IOException(AbstractC1214oR1.a(i4, "Failed to parse digest record #"), e);
                } catch (BufferUnderflowException e4) {
                    e = e4;
                    throw new IOException(AbstractC1214oR1.a(i4, "Failed to parse digest record #"), e);
                }
            }
            if (!arrayList.equals(arrayList2)) {
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            int iC3 = c(i);
            byte[] bArr = (byte[]) map.put(Integer.valueOf(iC3), bArrH2);
            if (bArr != null && !MessageDigest.isEqual(bArr, bArrH2)) {
                throw new SecurityException(d(iC3).concat(" contents digest does not match the digest specified by a preceding signer"));
            }
            ByteBuffer byteBufferF6 = f(byteBufferF);
            ArrayList arrayList3 = new ArrayList();
            int i6 = 0;
            while (byteBufferF6.hasRemaining()) {
                i6++;
                byte[] bArrH4 = h(byteBufferF6);
                try {
                    arrayList3.add(new BQ2((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrH4)), bArrH4));
                } catch (CertificateException e5) {
                    throw new SecurityException(AbstractC1214oR1.a(i6, "Failed to decode certificate #"), e5);
                }
            }
            if (arrayList3.isEmpty()) {
                throw new SecurityException("No certificates listed");
            }
            if (Arrays.equals(bArrH, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
            }
            throw new SecurityException("Public key mismatch between certificate and signature record");
        } catch (InvalidAlgorithmParameterException e6) {
            e = e6;
            throw new SecurityException(BN0.a("Failed to verify ", str2, " signature"), e);
        } catch (InvalidKeyException e7) {
            e = e7;
            throw new SecurityException(BN0.a("Failed to verify ", str2, " signature"), e);
        } catch (NoSuchAlgorithmException e8) {
            e = e8;
            throw new SecurityException(BN0.a("Failed to verify ", str2, " signature"), e);
        } catch (SignatureException e9) {
            e = e9;
            throw new SecurityException(BN0.a("Failed to verify ", str2, " signature"), e);
        } catch (InvalidKeySpecException e10) {
            e = e10;
            throw new SecurityException(BN0.a("Failed to verify ", str2, " signature"), e);
        }
    }

    public static byte[][] j(int[] iArr, HF2[] hf2Arr) throws DigestException {
        long j;
        int i;
        int length;
        long j2 = 0;
        long jZza = 0;
        int i2 = 0;
        while (true) {
            j = 1048576;
            if (i2 >= 3) {
                break;
            }
            jZza += (hf2Arr[i2].zza() + 1048575) / 1048576;
            i2++;
        }
        if (jZza >= 2097151) {
            throw new DigestException("Too many chunks: " + jZza);
        }
        int i3 = (int) jZza;
        byte[][] bArr = new byte[iArr.length][];
        int i4 = 0;
        while (true) {
            length = iArr.length;
            if (i4 >= length) {
                break;
            }
            byte[] bArr2 = new byte[(b(iArr[i4]) * i3) + 5];
            bArr2[0] = 90;
            g(i3, bArr2);
            bArr[i4] = bArr2;
            i4++;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        MessageDigest[] messageDigestArr = new MessageDigest[length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            String strD = d(iArr[i5]);
            try {
                messageDigestArr[i5] = MessageDigest.getInstance(strD);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(strD.concat(" digest not supported"), e);
            }
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (i = 3; i6 < i; i = 3) {
            HF2 hf2 = hf2Arr[i6];
            long j3 = j2;
            int i9 = i6;
            long jZza2 = hf2.zza();
            while (jZza2 > j2) {
                int iMin = (int) Math.min(jZza2, j);
                g(iMin, bArr3);
                for (int i10 = 0; i10 < length; i10++) {
                    messageDigestArr[i10].update(bArr3);
                }
                long j4 = j3;
                try {
                    hf2.a(messageDigestArr, j4, iMin);
                    int i11 = 0;
                    while (i11 < iArr.length) {
                        int i12 = iArr[i11];
                        HF2 hf22 = hf2;
                        byte[] bArr4 = bArr[i11];
                        int iB = b(i12);
                        byte[] bArr5 = bArr3;
                        MessageDigest messageDigest = messageDigestArr[i11];
                        MessageDigest[] messageDigestArr2 = messageDigestArr;
                        int iDigest = messageDigest.digest(bArr4, (i7 * iB) + 5, iB);
                        if (iDigest != iB) {
                            throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + iDigest);
                        }
                        i11++;
                        hf2 = hf22;
                        bArr3 = bArr5;
                        messageDigestArr = messageDigestArr2;
                    }
                    HF2 hf23 = hf2;
                    long j5 = iMin;
                    long j6 = j4 + j5;
                    jZza2 -= j5;
                    i7++;
                    j2 = 0;
                    j = 1048576;
                    hf2 = hf23;
                    j3 = j6;
                    bArr3 = bArr3;
                } catch (IOException e2) {
                    throw new DigestException(Vx1.a(i7, i8, "Failed to digest chunk #", " of section #"), e2);
                }
            }
            i8++;
            i6 = i9 + 1;
            j2 = 0;
            j = 1048576;
        }
        byte[][] bArr6 = new byte[iArr.length][];
        for (int i13 = 0; i13 < iArr.length; i13++) {
            int i14 = iArr[i13];
            byte[] bArr7 = bArr[i13];
            String strD2 = d(i14);
            try {
                bArr6[i13] = MessageDigest.getInstance(strD2).digest(bArr7);
            } catch (NoSuchAlgorithmException e3) {
                throw new RuntimeException(strD2.concat(" digest not supported"), e3);
            }
        }
        return bArr6;
    }

    public static X509Certificate[][] k(FileChannel fileChannel, C0703gN2 c0703gN2) {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferF = f(c0703gN2.a);
                int i = 0;
                while (byteBufferF.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(i(f(byteBufferF), map, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i <= 0) {
                    throw new SecurityException("No signers found");
                }
                if (map.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                if (map.isEmpty()) {
                    throw new SecurityException("No digests provided");
                }
                long j = c0703gN2.b;
                C0766hI2 c0766hI2 = new C0766hI2(fileChannel, 0L, j);
                long j2 = c0703gN2.d;
                long j3 = c0703gN2.c;
                C0766hI2 c0766hI22 = new C0766hI2(fileChannel, j3, j2 - j3);
                ByteBuffer byteBufferDuplicate = c0703gN2.e.duplicate();
                byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                AbstractC0966kV2.b(byteBufferDuplicate);
                int iPosition = byteBufferDuplicate.position() + 16;
                if (j < 0 || j > 4294967295L) {
                    throw new IllegalArgumentException("uint32 value of out range: " + j);
                }
                byteBufferDuplicate.putInt(byteBufferDuplicate.position() + iPosition, (int) j);
                JB2 jb2 = new JB2(byteBufferDuplicate);
                int size = map.size();
                int[] iArr = new int[size];
                Iterator it = map.keySet().iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    iArr[i2] = ((Integer) it.next()).intValue();
                    i2++;
                }
                try {
                    byte[][] bArrJ = j(iArr, new HF2[]{c0766hI2, c0766hI22, jb2});
                    for (int i3 = 0; i3 < size; i3++) {
                        int i4 = iArr[i3];
                        if (!MessageDigest.isEqual((byte[]) map.get(Integer.valueOf(i4)), bArrJ[i3])) {
                            throw new SecurityException(d(i4).concat(" digest of contents did not verify"));
                        }
                    }
                    return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
                } catch (DigestException e2) {
                    throw new SecurityException("Failed to compute digest(s) of contents", e2);
                }
            } catch (IOException e3) {
                throw new SecurityException("Failed to read list of signers", e3);
            }
        } catch (CertificateException e4) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e4);
        }
    }
}
