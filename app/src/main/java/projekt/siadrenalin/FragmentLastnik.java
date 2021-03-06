package projekt.siadrenalin;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.siadrenalin.R;

public class FragmentLastnik extends Fragment {

    EditText edtLastnik;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //set the layout you want to display in First Fragment
        View view = inflater.inflate(R.layout.fragment_kontakt_lastnik,
                container, false);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.spinner_kontakt_lastnik, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner sp_zadeva = (Spinner)view.findViewById(R.id.sp_zadeva_lastnik);
        sp_zadeva.setAdapter(adapter);


        edtLastnik = (EditText)view.findViewById(R.id.editText_kontakt_lastnik);

        Button btn_poslji = (Button)view.findViewById(R.id.gumb_kontakt_lastnik);
        btn_poslji.setText(R.string.poslji);
        btn_poslji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtLastnik.getText().toString().equals("") || sp_zadeva.getSelectedItemPosition() == 0)
                {
                    Toast.makeText(getActivity().getApplicationContext(), "Vnesite podatke!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    Uri data = Uri.parse("mailto:" + "toplak.mitja@gmail.com" + "?subject=" + sp_zadeva.getSelectedItem().toString() + "&body=" + edtLastnik.getText());
                    intent.setData(data);
                    startActivity(intent);
                }
            }
        });

        return view;
    }

}
