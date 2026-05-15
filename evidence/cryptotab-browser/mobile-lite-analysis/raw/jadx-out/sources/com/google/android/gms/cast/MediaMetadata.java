package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.C1838zN0;
import defpackage.ML2;
import defpackage.OM2;
import defpackage.YD2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "MediaMetadataCreator")
@SafeParcelable.Reserved({1})
public class MediaMetadata extends AbstractSafeParcelable {
    public static final C1838zN0 x;
    public final ArrayList t;
    public final Bundle u;
    public int v;
    public static final String[] w = {null, "String", "int", "double", "ISO-8601 date String"};
    public static final Parcelable.Creator CREATOR = new YD2();

    static {
        C1838zN0 c1838zN0 = new C1838zN0();
        c1838zN0.a(4, "com.google.android.gms.cast.metadata.CREATION_DATE", "creationDateTime");
        c1838zN0.a(4, "com.google.android.gms.cast.metadata.RELEASE_DATE", "releaseDate");
        c1838zN0.a(4, "com.google.android.gms.cast.metadata.BROADCAST_DATE", "originalAirdate");
        c1838zN0.a(1, "com.google.android.gms.cast.metadata.TITLE", "title");
        c1838zN0.a(1, "com.google.android.gms.cast.metadata.SUBTITLE", "subtitle");
        c1838zN0.a(1, "com.google.android.gms.cast.metadata.ARTIST", "artist");
        c1838zN0.a(1, "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "albumArtist");
        c1838zN0.a(1, "com.google.android.gms.cast.metadata.ALBUM_TITLE", "albumName");
        c1838zN0.a(1, "com.google.android.gms.cast.metadata.COMPOSER", "composer");
        c1838zN0.a(2, "com.google.android.gms.cast.metadata.DISC_NUMBER", "discNumber");
        c1838zN0.a(2, "com.google.android.gms.cast.metadata.TRACK_NUMBER", "trackNumber");
        c1838zN0.a(2, "com.google.android.gms.cast.metadata.SEASON_NUMBER", "season");
        c1838zN0.a(2, "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "episode");
        c1838zN0.a(1, "com.google.android.gms.cast.metadata.SERIES_TITLE", "seriesTitle");
        c1838zN0.a(1, "com.google.android.gms.cast.metadata.STUDIO", "studio");
        c1838zN0.a(2, "com.google.android.gms.cast.metadata.WIDTH", "width");
        c1838zN0.a(2, "com.google.android.gms.cast.metadata.HEIGHT", "height");
        c1838zN0.a(1, "com.google.android.gms.cast.metadata.LOCATION_NAME", "location");
        c1838zN0.a(3, "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "latitude");
        c1838zN0.a(3, "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "longitude");
        c1838zN0.a(5, "com.google.android.gms.cast.metadata.SECTION_DURATION", "sectionDuration");
        c1838zN0.a(5, "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA", "sectionStartTimeInMedia");
        c1838zN0.a(5, "com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME", "sectionStartAbsoluteTime");
        c1838zN0.a(5, "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER", "sectionStartTimeInContainer");
        c1838zN0.a(2, "com.google.android.gms.cast.metadata.QUEUE_ITEM_ID", "queueItemId");
        c1838zN0.a(1, "com.google.android.gms.cast.metadata.BOOK_TITLE", "bookTitle");
        c1838zN0.a(2, "com.google.android.gms.cast.metadata.CHAPTER_NUMBER", "chapterNumber");
        c1838zN0.a(1, "com.google.android.gms.cast.metadata.CHAPTER_TITLE", "chapterTitle");
        x = c1838zN0;
    }

    public MediaMetadata(ArrayList arrayList, Bundle bundle, int i) {
        this.t = arrayList;
        this.u = bundle;
        this.v = i;
    }

    public static boolean g2(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !g2((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return g2(this.u, mediaMetadata.u) && this.t.equals(mediaMetadata.t);
    }

    public final String f2(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        Integer num = (Integer) x.c.get(str);
        int iIntValue = num != null ? num.intValue() : 0;
        if (iIntValue == 1 || iIntValue == 0) {
            return this.u.getString(str);
        }
        String str2 = w[1];
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + str.length() + 21);
        sb.append("Value for ");
        sb.append(str);
        sb.append(" must be a ");
        sb.append(str2);
        throw new IllegalArgumentException(sb.toString());
    }

    public final void h2(JSONObject jSONObject) {
        HashSet hashSet;
        Bundle bundle = this.u;
        bundle.clear();
        ArrayList arrayList = this.t;
        arrayList.clear();
        int i = 0;
        this.v = 0;
        try {
            this.v = jSONObject.getInt("metadataType");
        } catch (JSONException unused) {
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("images");
        if (jSONArrayOptJSONArray != null) {
            OM2.a(arrayList, jSONArrayOptJSONArray);
        }
        ArrayList arrayList2 = new ArrayList();
        int i2 = this.v;
        if (i2 == 0) {
            Collections.addAll(arrayList2, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i2 == 1) {
            Collections.addAll(arrayList2, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i2 == 2) {
            Collections.addAll(arrayList2, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE");
        } else if (i2 == 3) {
            Collections.addAll(arrayList2, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i2 == 4) {
            Collections.addAll(arrayList2, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE");
        } else if (i2 == 5) {
            Collections.addAll(arrayList2, "com.google.android.gms.cast.metadata.CHAPTER_TITLE", "com.google.android.gms.cast.metadata.CHAPTER_NUMBER", "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.BOOK_TITLE", "com.google.android.gms.cast.metadata.SUBTITLE");
        }
        if (ML2.b) {
            Collections.addAll(arrayList2, "com.google.android.gms.cast.metadata.SECTION_DURATION", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA", "com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER");
        }
        Collections.addAll(arrayList2, "com.google.android.gms.cast.metadata.QUEUE_ITEM_ID");
        HashSet hashSet2 = new HashSet(arrayList2);
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!"metadataType".equals(next)) {
                    C1838zN0 c1838zN0 = x;
                    String str = (String) c1838zN0.b.get(next);
                    if (str != null) {
                        if (hashSet2.contains(str)) {
                            try {
                                Object obj = jSONObject.get(next);
                                if (obj != null) {
                                    Integer num = (Integer) c1838zN0.c.get(str);
                                    int iIntValue = num != null ? num.intValue() : i;
                                    if (iIntValue == 1) {
                                        hashSet = hashSet2;
                                        if (obj instanceof String) {
                                            bundle.putString(str, (String) obj);
                                        }
                                    } else if (iIntValue == 2) {
                                        hashSet = hashSet2;
                                        if (obj instanceof Integer) {
                                            bundle.putInt(str, ((Integer) obj).intValue());
                                        }
                                    } else if (iIntValue == 3) {
                                        hashSet = hashSet2;
                                        double dOptDouble = jSONObject.optDouble(next);
                                        if (!Double.isNaN(dOptDouble)) {
                                            bundle.putDouble(str, dOptDouble);
                                        }
                                    } else if (iIntValue == 4) {
                                        hashSet = hashSet2;
                                        if ((obj instanceof String) && OM2.c((String) obj) != null) {
                                            bundle.putString(str, (String) obj);
                                        }
                                    } else if (iIntValue == 5) {
                                        hashSet = hashSet2;
                                        try {
                                            bundle.putLong(str, (long) (jSONObject.optLong(next) * 1000.0d));
                                        } catch (JSONException unused2) {
                                        }
                                    }
                                }
                            } catch (JSONException unused3) {
                            }
                        }
                        hashSet = hashSet2;
                    } else {
                        hashSet = hashSet2;
                        Object obj2 = jSONObject.get(next);
                        if (obj2 instanceof String) {
                            bundle.putString(next, (String) obj2);
                        } else if (obj2 instanceof Integer) {
                            bundle.putInt(next, ((Integer) obj2).intValue());
                        } else if (obj2 instanceof Double) {
                            bundle.putDouble(next, ((Double) obj2).doubleValue());
                        }
                    }
                    hashSet2 = hashSet;
                    i = 0;
                }
            }
        } catch (JSONException unused4) {
        }
    }

    public final int hashCode() {
        Bundle bundle = this.u;
        Iterator<String> it = bundle.keySet().iterator();
        int iHashCode = 17;
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + bundle.get(it.next()).hashCode();
        }
        return this.t.hashCode() + (iHashCode * 31);
    }

    public final JSONObject toJson() {
        int size;
        int i;
        Bundle bundle;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.v);
        } catch (JSONException unused) {
        }
        JSONArray jSONArrayB = OM2.b(this.t);
        if (jSONArrayB != null && jSONArrayB.length() != 0) {
            try {
                jSONObject.put("images", jSONArrayB);
            } catch (JSONException unused2) {
            }
        }
        ArrayList arrayList = new ArrayList();
        int i2 = this.v;
        if (i2 == 0) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i2 == 1) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i2 == 2) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE");
        } else if (i2 == 3) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i2 == 4) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE");
        } else if (i2 == 5) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.CHAPTER_TITLE", "com.google.android.gms.cast.metadata.CHAPTER_NUMBER", "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.BOOK_TITLE", "com.google.android.gms.cast.metadata.SUBTITLE");
        }
        Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.SECTION_DURATION", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA", "com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER", "com.google.android.gms.cast.metadata.QUEUE_ITEM_ID");
        try {
            size = arrayList.size();
            i = 0;
        } catch (JSONException unused3) {
        }
        while (true) {
            bundle = this.u;
            if (i >= size) {
                break;
            }
            Object obj = arrayList.get(i);
            i++;
            String str = (String) obj;
            if (bundle.containsKey(str)) {
                C1838zN0 c1838zN0 = x;
                Integer num = (Integer) c1838zN0.c.get(str);
                int iIntValue = num != null ? num.intValue() : 0;
                HashMap map = c1838zN0.a;
                if (iIntValue != 1) {
                    if (iIntValue == 2) {
                        jSONObject.put((String) map.get(str), bundle.getInt(str));
                    } else if (iIntValue == 3) {
                        jSONObject.put((String) map.get(str), bundle.getDouble(str));
                    } else if (iIntValue != 4) {
                        if (iIntValue == 5) {
                            jSONObject.put((String) map.get(str), bundle.getLong(str) / 1000.0d);
                        }
                    }
                }
                jSONObject.put((String) map.get(str), bundle.getString(str));
            }
            return jSONObject;
        }
        for (String str2 : bundle.keySet()) {
            if (!str2.startsWith("com.google.")) {
                Object obj2 = bundle.get(str2);
                if (obj2 instanceof String) {
                    jSONObject.put(str2, obj2);
                } else if (obj2 instanceof Integer) {
                    jSONObject.put(str2, obj2);
                } else if (obj2 instanceof Double) {
                    jSONObject.put(str2, obj2);
                }
            }
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.t, false);
        SafeParcelWriter.writeBundle(parcel, 3, this.u, false);
        SafeParcelWriter.writeInt(parcel, 4, this.v);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public MediaMetadata(int i) {
        this(new ArrayList(), new Bundle(), i);
    }
}
