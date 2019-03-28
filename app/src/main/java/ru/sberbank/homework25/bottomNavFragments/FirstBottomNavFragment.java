package ru.sberbank.homework25.bottomNavFragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import ru.sberbank.homework25.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstBottomNavFragment extends Fragment {

    private Button firstButton;
    private Button secondButton;
    private Button globalButton;

    public FirstBottomNavFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first_bottom_nav, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initNav();
    }

    private void initNav() {
        final NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        setNav(navController);
    }

    private void setNav(NavController navController) {
        firstButton.setOnClickListener(v1 -> navController.navigate(R.id.action_firstBottomNavFragment_to_secondBottomNavFragment));
        secondButton.setOnClickListener(v1 -> navController.navigate(R.id.action_firstBottomNavFragment_to_thirdBottomNavFragment));
        globalButton.setOnClickListener(v -> navController.navigate(R.id.action_global_globalDialogFragment));
    }

    private void initViews(View view) {
        firstButton = view.findViewById(R.id.firstfragmentTosecond_button);
        secondButton = view.findViewById(R.id.firstfragmentTothird_button);
        globalButton = view.findViewById(R.id.globalFragmentButton);
    }
}
