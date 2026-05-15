package org.chromium.media;

import android.content.ContentResolver;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.audiofx.AcousticEchoCanceler;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings;
import android.util.Log;
import defpackage.AbstractC0042Dg;
import defpackage.AbstractC0066Fg;
import defpackage.AbstractC1499tM;
import defpackage.AbstractC1872zv;
import defpackage.C0056Eg;
import defpackage.Hg;
import defpackage.Jg;
import defpackage.Kg;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Optional;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class AudioManagerAndroid {
    public static Optional k;
    public final AudioManager a;
    public final long b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public final ContentResolver g;
    public Kg h;
    public HandlerThread i;
    public final AbstractC0066Fg j;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public class AudioDeviceName {
        public final int a;
        public final String b;

        public AudioDeviceName(int i, String str) {
            this.a = i;
            this.b = str;
        }

        public final String id() {
            return String.valueOf(this.a);
        }

        public final String name() {
            return this.b;
        }
    }

    public AudioManagerAndroid(long j) {
        int i = AbstractC1872zv.a;
        this.b = j;
        AudioManager audioManager = (AudioManager) AbstractC1499tM.a.getSystemService("audio");
        this.a = audioManager;
        this.g = AbstractC1499tM.a.getContentResolver();
        if (Build.VERSION.SDK_INT >= 31) {
            this.j = new Hg(audioManager);
            return;
        }
        Jg jg = new Jg(audioManager);
        jg.d = -1;
        jg.f = new boolean[5];
        this.j = jg;
    }

    public static boolean acousticEchoCancelerIsAvailable() {
        return AcousticEchoCanceler.isAvailable();
    }

    public static AudioManagerAndroid createAudioManagerAndroid(long j) {
        return new AudioManagerAndroid(j);
    }

    public static int getAudioEncodingFormatsSupported() {
        boolean z = true;
        int i = 0;
        for (AudioDeviceInfo audioDeviceInfo : ((AudioManager) AbstractC1499tM.a.getSystemService("audio")).getDevices(2)) {
            int[] encodings = audioDeviceInfo.getEncodings();
            if (audioDeviceInfo.isSink() && audioDeviceInfo.getType() == 9) {
                int i2 = 0;
                for (int i3 : encodings) {
                    if (i3 == 2) {
                        i2 |= 1;
                    } else if (i3 == 13) {
                        i2 |= 128;
                    } else if (i3 == 5) {
                        i2 |= 4;
                    } else if (i3 == 6) {
                        i2 |= 8;
                    } else if (i3 == 7) {
                        i2 |= 16;
                    } else if (i3 == 8) {
                        i2 |= 32;
                    }
                }
                if (z) {
                    z = false;
                    i = i2;
                } else {
                    i &= i2;
                }
            }
        }
        return i;
    }

    public static int getMinInputFrameSize(int i, int i2) {
        int i3;
        if (i2 == 1) {
            i3 = 16;
        } else {
            if (i2 != 2) {
                return -1;
            }
            i3 = 12;
        }
        return (AudioRecord.getMinBufferSize(i, i3, 2) / 2) / i2;
    }

    public static int getMinOutputFrameSize(int i, int i2) {
        int i3;
        if (i2 == 1) {
            i3 = 4;
        } else {
            if (i2 != 2) {
                return -1;
            }
            i3 = 12;
        }
        return (AudioTrack.getMinBufferSize(i, i3, 2) / 2) / i2;
    }

    public static boolean isAudioSinkConnected() {
        for (AudioDeviceInfo audioDeviceInfo : ((AudioManager) AbstractC1499tM.a.getSystemService("audio")).getDevices(2)) {
            if (audioDeviceInfo.isSink()) {
                return true;
            }
        }
        return false;
    }

    public final void a() {
        if (this.i == null) {
            return;
        }
        this.g.unregisterContentObserver(this.h);
        this.h = null;
        this.i.quit();
        try {
            this.i.join();
        } catch (InterruptedException e) {
            Log.e("cr_media", "Thread.join() exception: ", e);
        }
        this.i = null;
    }

    public final void close() {
        int i = AbstractC1872zv.a;
        if (this.d) {
            a();
            this.j.a();
            this.d = false;
        }
    }

    public final AudioDeviceName[] getAudioInputDeviceNames() {
        boolean[] zArrB;
        if (!this.d) {
            return null;
        }
        boolean z = AbstractC1499tM.a.checkSelfPermission("android.permission.RECORD_AUDIO") == 0;
        if (!this.c || !z) {
            Log.w("cr_media", "Requires MODIFY_AUDIO_SETTINGS and RECORD_AUDIO. No audio device will be available for recording");
            return null;
        }
        C0056Eg c0056Eg = this.j.a;
        synchronized (c0056Eg.a) {
            zArrB = c0056Eg.c.b();
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (boolean z2 : zArrB) {
            if (z2) {
                i++;
            }
        }
        AudioDeviceName[] audioDeviceNameArr = new AudioDeviceName[i];
        int i2 = 0;
        for (int i3 = 0; i3 < zArrB.length; i3++) {
            if (zArrB[i3]) {
                String[] strArr = AbstractC0042Dg.a;
                audioDeviceNameArr[i2] = new AudioDeviceName(i3, strArr[i3]);
                arrayList.add(strArr[i3]);
                i2++;
            }
        }
        return audioDeviceNameArr;
    }

    public final int getAudioLowLatencyOutputFrameSize() {
        String property = this.a.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
        if (property == null) {
            return 256;
        }
        return Integer.parseInt(property);
    }

    public final int getNativeOutputSampleRate() {
        String property = this.a.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        if (property == null) {
            return 44100;
        }
        return Integer.parseInt(property);
    }

    public final int getOutputLatency() {
        Method method;
        int i = AbstractC1872zv.a;
        if (k == null) {
            try {
                method = AudioManager.class.getMethod("getOutputLatency", Integer.TYPE);
            } catch (NoSuchMethodException unused) {
                method = null;
            }
            k = Optional.ofNullable(method);
        }
        if (k.isPresent()) {
            try {
                return ((Integer) ((Method) k.get()).invoke(this.a, 3)).intValue();
            } catch (Exception unused2) {
            }
        }
        return 0;
    }

    public final void init() {
        int i = AbstractC1872zv.a;
        if (this.d) {
            return;
        }
        this.c = AbstractC1499tM.a.checkSelfPermission("android.permission.MODIFY_AUDIO_SETTINGS") == 0;
        this.j.c();
        this.d = true;
    }

    public final boolean isAudioLowLatencySupported() {
        return AbstractC1499tM.a.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    }

    public final void setCommunicationAudioModeOn(boolean z) {
        int i = AbstractC1872zv.a;
        if (this.d) {
            if (!this.c) {
                Log.w("cr_media", "MODIFY_AUDIO_SETTINGS is missing => client will run with reduced functionality");
                return;
            }
            AbstractC0066Fg abstractC0066Fg = this.j;
            AudioManager audioManager = this.a;
            if (z) {
                this.e = abstractC0066Fg.d();
                this.f = audioManager.isMicrophoneMute();
                abstractC0066Fg.g(true);
                if (this.i == null) {
                    HandlerThread handlerThread = new HandlerThread("SettingsObserver");
                    this.i = handlerThread;
                    handlerThread.start();
                    Kg kg = new Kg(this, new Handler(this.i.getLooper()));
                    this.h = kg;
                    this.g.registerContentObserver(Settings.System.CONTENT_URI, true, kg);
                }
            } else {
                a();
                abstractC0066Fg.g(false);
                boolean z2 = this.f;
                if (audioManager.isMicrophoneMute() != z2) {
                    audioManager.setMicrophoneMute(z2);
                }
                abstractC0066Fg.i(this.e);
            }
            if (z) {
                try {
                    audioManager.setMode(3);
                    return;
                } catch (SecurityException e) {
                    int i2 = AbstractC1872zv.a;
                    throw e;
                }
            }
            try {
                audioManager.setMode(0);
            } catch (SecurityException e2) {
                int i3 = AbstractC1872zv.a;
                throw e2;
            }
        }
    }

    public final boolean setDevice(String str) {
        if (!this.d) {
            return false;
        }
        boolean z = AbstractC1499tM.a.checkSelfPermission("android.permission.RECORD_AUDIO") == 0;
        if (!this.c || !z) {
            Log.w("cr_media", "Requires MODIFY_AUDIO_SETTINGS and RECORD_AUDIO. Selected device will not be available for recording");
            return false;
        }
        AbstractC0066Fg abstractC0066Fg = this.j;
        abstractC0066Fg.getClass();
        int i = str.isEmpty() ? -2 : Integer.parseInt(str);
        C0056Eg c0056Eg = abstractC0066Fg.a;
        c0056Eg.getClass();
        int i2 = 4;
        if (i == -2 || (i >= 0 && i <= 4)) {
            synchronized (c0056Eg.a) {
                try {
                    c0056Eg.b = i;
                    boolean[] zArrB = c0056Eg.c.b();
                    if (i != -2) {
                        i2 = zArrB[i] ? c0056Eg.b : -1;
                    } else if (zArrB[1]) {
                        i2 = 1;
                    } else if (!zArrB[4]) {
                        i2 = 3;
                        if (!zArrB[3]) {
                            i2 = 0;
                        }
                    }
                } finally {
                }
            }
        } else {
            i2 = -1;
        }
        if (i2 == -1) {
            return false;
        }
        abstractC0066Fg.f(i2);
        return true;
    }
}
