package rpcs.jacob.ema.Entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jacobnelson on 11/12/15.
 */
public class User implements Parcelable {
    private String name;
    private String password;

    // getter
    public String getName() { return name; }
    public String getPassword() { return password; }
    // setter
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(password);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public User createFromParcel(Parcel in) {
            User user = new User();
            user.name = in.readString();
            user.password = in.readString();
            return user;
        }

        @Override
        public Object[] newArray(int size) {
            return new Object[0];
        }

    };
}
