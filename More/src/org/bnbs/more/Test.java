package org.bnbs.more;

import java.util.Enumeration;
import java.util.Hashtable;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Test {

	/**
	 * @param args
	 */

	public final static String META_SCORE_KEY = "meta_score";
	public final static String SCORE_KEY = "score";
	public final static String ALBUM_KEY = "release";
	public final static String TITLE_KEY = "track";
	public final static String TRACK_ID_KEY = "track_id";
	public final static String ARTIST_KEY = "artist";

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub

		Hashtable<String, String> match = new Hashtable<String, String>();
		JSONObject jobj = new JSONObject(
				"{\"total_time\": 28, \"track\": null, \"score\": 0, \"ok\": true, \"artist\": null, \"release\": null, \"message\": \"no results found (type 7)\", \"qtime\": 14, \"match\": false, \"track_id\": null}");

		Log.d("Fingerprinter", "jSON: " + jobj.toString());

		if (jobj.getBoolean("match") == true) {
			if (jobj.has(SCORE_KEY))
				match.put(META_SCORE_KEY, jobj.getDouble(SCORE_KEY) + "");
			if (jobj.has(ARTIST_KEY))
				match.put(ARTIST_KEY, jobj.getString(ARTIST_KEY));
			if (jobj.has(ALBUM_KEY))
				match.put(ALBUM_KEY, jobj.getString(ALBUM_KEY));

			if (jobj.has(TITLE_KEY)) {
				match.put(TITLE_KEY, jobj.getString(TITLE_KEY));
			}
		}
		System.out.println(match.get(SCORE_KEY));
		System.out.println(match.get(TITLE_KEY));
		System.out.println(match.get(ARTIST_KEY));

	}
}
