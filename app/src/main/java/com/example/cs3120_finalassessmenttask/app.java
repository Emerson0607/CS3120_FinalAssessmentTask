package com.example.cs3120_finalassessmenttask;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ClipboardManager;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


public class app extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        TextView tvContext = findViewById(R.id.tvContext);
        registerForContextMenu(tvContext);
    }

    public void btnPop(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.pop);
        popupMenu.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        TextView tvContext = findViewById(R.id.tvContext);
        switch (item.getItemId()){
            case R.id.bold:
                tvContext.setTypeface(null,Typeface.BOLD);
                tvContext.getPaint().setUnderlineText(false);
                Toast.makeText(this, "Bold selected!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.italize:
                tvContext.setTypeface(null,Typeface.ITALIC);
                tvContext.getPaint().setUnderlineText(false);
                Toast.makeText(this, "Italize is selected!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.underline:
                tvContext.setPaintFlags(tvContext.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
                Toast.makeText(this, "Underline is selected!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.context, menu);
    }

    @Override
    public boolean onContextItemSelected( MenuItem item) {
        TextView tvContext = findViewById(R.id.tvContext);
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        switch (item.getItemId()){
            case R.id.cut:
                Toast.makeText(this, "Cut is selected!", Toast.LENGTH_SHORT).show();
                clipboard.setText(tvContext.getText());
                tvContext.setText("");

                return true;
            case R.id.copy:
                Toast.makeText(this, "Copy is selected!", Toast.LENGTH_SHORT).show();
                clipboard.setText(tvContext.getText());
                return true;
            case R.id.delete:
                Toast.makeText(this, "Delete is selected!", Toast.LENGTH_SHORT).show();
                tvContext.setText("");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.dark:
                Toast.makeText(this, "Dark mode is selected!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.settings:
                Toast.makeText(this, "Setting is selected!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Toast.makeText(this, "Help is selected!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}