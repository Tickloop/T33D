package com.tickloop.t33d;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tickloop.t33d.api.models.Player;

public class ProfileFragment extends Fragment implements View.OnClickListener {
    private static String TAG = "ProfileFragmentTAG";

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // setup on click listeners
        Button take_pic = view.findViewById(R.id.take_picture_button);
        take_pic.setOnClickListener(this);

        // get the data to show to the user
        Player p = (Player) getActivity().getIntent().getSerializableExtra("player");
        Log.d(TAG, "onViewCreated: " + p);

        // set the values of textViews
        EditText username = view.findViewById(R.id.username);
        username.setText(p.getUsername());

        EditText password = view.findViewById(R.id.password);
        password.setText("password");
    }

    private void takePic() {
        Intent takPic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takPic, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            ImageView user_img = getActivity().findViewById(R.id.user_image);
            user_img.setImageBitmap((Bitmap) data.getExtras().get("data"));
        }
    }

    @Override
    public void onClick(View view) {
        final int vId = view.getId();

        if(vId == R.id.take_picture_button)
            takePic();
        else
            Log.d(TAG, "onClick: OnClick called with error binding");
    }
}