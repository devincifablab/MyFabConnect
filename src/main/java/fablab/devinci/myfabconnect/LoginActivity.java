package fablab.devinci.myfabconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText SendValue;
    EditText SendPwd;
    Button SendEditTextValue;
    Button AccessSignup;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SendEditTextValue = (Button)findViewById(R.id.login);
        SendValue = (EditText)findViewById(R.id.email);
        SendPwd = (EditText)findViewById(R.id.password);

        SendEditTextValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*intent =  new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("EditTextValue", SendValue.getText().toString());
                startActivity(intent); */

                CheckPassword(SendValue.getText().toString(),MD5(SendPwd.getText().toString()));


            }
        });

        AccessSignup = (Button) findViewById(R.id.signup);

        AccessSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent =  new Intent(getApplicationContext(),SignupActivity.class);
                //intent.putExtra("EditTextValue", SendValue.getText().toString());
                startActivity(intent);


            }
        });
    }


    public String CheckPassword(final String user, final String password) {

        final String apikey = "GEPRSokac9uKRb00G0X5RXt9OWxj66cN";
        String url="http://myfab.pe.hu/api/v1/authz/oauth.php";

        final StringRequest request = new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Results", response);

                try {
                    JSONObject jsonObj = new JSONObject(response);
                    Log.d("Conversion", jsonObj.toString());
                    String msg = (String) jsonObj.get("message");
                    String id = (String) jsonObj.get("id");
                    Log.d("Conversion2", msg);

                    if (msg.equals("success"))
                    {
                        intent =  new Intent(getApplicationContext(),MainActivity.class);
                        intent.putExtra("Username", user);
                        intent.putExtra("Id", id);
                        startActivity(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                //  mytxtvw = (TextView) findViewById(R.id.txtview);
                //  mytxtvw.setText(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError response) {
//                Log.e("Results",response.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("email", user);
                params.put("pwd", password);
                params.put("key", apikey);

                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);


        return user;
    }


    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

}
