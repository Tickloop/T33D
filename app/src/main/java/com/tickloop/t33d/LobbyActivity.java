package com.tickloop.t33d;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class LobbyActivity extends Activity {
    private static final String TAG = "LobbyActivityTAG";
    private ArrayList<String> playerNames = new ArrayList<String>();
    private final View.OnClickListener launchGame = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: Launch Game was fired");

            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
            intent.putExtra("playerList", playerNames);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        playerNames.add("Sam");
        playerNames.add("Jim");
        playerNames.add("Tim");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lobby);
        ListView players = findViewById(R.id.playerList);
        ArrayAdapter<String> playerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, playerNames);
        players.setAdapter(playerAdapter);
        boolean lobbyChange = false;
        String username="";
        //get new username if needed
        if(lobbyChange){
            addPlayer(username, playerAdapter);
        }

        ((Button) findViewById(R.id.play_button)).setOnClickListener(launchGame);
        Button addPlayers = (Button) findViewById(R.id.add_player_button);
        addPlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertBuild = new AlertDialog.Builder(LobbyActivity.this);
                EditText playerInput = new EditText(LobbyActivity.this);
                playerInput.setContentDescription("Enter Player Name");
                alertBuild.setView(playerInput);
                alertBuild.setPositiveButton("Add Player", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String inputPlayer = playerInput.getText().toString();
                        addPlayer(inputPlayer, playerAdapter);
                    }
                });
                alertBuild.show();
            }
        });
    }


    public void addPlayer(String username, ArrayAdapter adapter){

        adapter.add(username);
    }

    /*private class PlayerHolder extends RecyclerView.ViewHolder {
        private final TextView mPlayerInfoTextView;

        PlayerHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.activity_lobby, parent, false));

            mPlayerInfoTextView = itemView.findViewById(R.id.playerTextView);
        }

        void bind() {
            //String mDescriptionStr = getSensorDescription(sensor);
            String playerName = playerNames.get(0);
            mPlayerInfoTextView.setText(playerName);
        }
    }

    private class PlayerAdapter extends RecyclerView.Adapter<PlayerHolder> {
        private final List<String> mPlayerList;

        PlayerAdapter(List<String> playerList) {
            mPlayerList = playerList;
        }
        private final TextView playerTextView;
        public ViewHolder(View view){
            super(view);
            playerTextView = (TextView) view.findViewById(R.id.playerTextView);

        }



        @NonNull
        @Override
        public PlayerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(requireActivity());
            return new PlayerHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull PlayerHolder holder, int position) {
            String playerName = mPlayerList.get(position);
            playerTextView.setText(playerName);
        }

        @Override
        public int getItemCount() {
            return mPlayerList.size();
        }
    }*/

}