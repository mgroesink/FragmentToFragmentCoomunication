package nl.rocvantwente.rsk01.fragmenttofragmentcoomunication;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment {

    private static final String TAG = "BFragment";

    // Vars
    private IMainActivity mIMainActivity;
    private TextView mDisplayMessage;
    private String mIncomingMessage = "";

    public BFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIMainActivity.setToolbarTitle(getTag());

        Bundle bundle = this.getArguments();
        if(bundle != null){
            mIncomingMessage = bundle.getString(getString(R.string.intent_message));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_b, container, false);
        mDisplayMessage = (TextView)view.findViewById(R.id.incoming_message);
        setIncomingMessage();
        return view;
    }

    private void setIncomingMessage(){
        if(!mIncomingMessage.equals("")){
            mDisplayMessage.setText(mIncomingMessage);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIMainActivity = (MainActivity)getActivity();
    }

}
