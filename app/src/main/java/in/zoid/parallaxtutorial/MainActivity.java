package in.zoid.parallaxtutorial;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends Activity {
    private int lastTop = 0;
    ImageView image;
    ListView listView;

    ArrayAdapter adapter;
    ArrayList<String> items = new ArrayList<>();

    public void parallax(final View v) {
        final Rect r = new Rect();
        v.getLocalVisibleRect(r);

        if (lastTop != r.top) {
            lastTop = r.top;
            v.post(new Runnable() {
                @Override
                public void run() {
                    v.setY((float) (r.top / 2.0));
                }
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);

        items.add("List Item 1");
        items.add("List Item 2");
        items.add("List Item 3");
        items.add("List Item 4");
        items.add("List Item 5");
        items.add("List Item 6");
        items.add("List Item 7");
        items.add("List Item 8");
        items.add("List Item 9");
        items.add("List Item 10");
        items.add("List Item 11");
        items.add("List Item 12");
        items.add("List Item 13");
        items.add("List Item 14");
        items.add("List Item 15");
        items.add("List Item 16");
        items.add("List Item 17");
        items.add("List Item 18");
        items.add("List Item 19");
        items.add("List Item 20");

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        View view = getLayoutInflater().inflate(R.layout.header, null, false);
        image = (ImageView) view.findViewById(R.id.image);
        listView.addHeaderView(view);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                parallax(image);
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                parallax(image);
            }
        });
    }
}