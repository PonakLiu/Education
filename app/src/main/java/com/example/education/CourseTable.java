package com.example.education;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.education.objects.Subject;
import com.zhuangfei.timetable.TimetableView;
import com.zhuangfei.timetable.listener.ISchedule;
import com.zhuangfei.timetable.model.Schedule;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class CourseTable extends AppCompatActivity {
    TimetableView mTimetableView;

    TextView titleTextView;
    List<Subject> mySubjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_course_table);
        mySubjects = loadDefaultSubjects();

        initTimetableView();
    }

    //初始化课程控件
    private void initTimetableView() {
        //获取控件
        mTimetableView = findViewById(R.id.id_timetableView);
        mTimetableView.source(mySubjects)
                .callback(new ISchedule.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, List<Schedule> scheduleList) {
                        display(scheduleList);
                    }
                })
                .callback(new ISchedule.OnWeekChangedListener() {
                    @Override
                    public void onWeekChanged(int curWeek) {
                        Toast.makeText(CourseTable.this, "第" + curWeek + "周", Toast.LENGTH_SHORT).show();
                    }
                })
                .showView();
    }

    //显示内容
    protected void display(List<Schedule> beans) {
        String str = "";
        for (Schedule bean : beans) {
            str += bean.getName() + "、";
        }
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    public static List<Subject> loadDefaultSubjects() {
        //json转义
        String json = "[[\"2017-2018学年秋\", \"\", \"\", \"计算机组成原理\", \"\", \"\", \"\", \"\", \"刘静\", \"\", \"\", \"1周上\", 1, 1, 2, \"\", \"计算机综合楼106\", \"\"]," +
                "[\"2017-2018学年秋\", \"\", \"\", \"hahaha\", \"\", \"\", \"\", \"\", \"刘静\", \"\", \"\", \"2周上\", 1, 1, 4, \"\", \"计算机综合楼106\", \"\"]," +
                "[\"2017-2018学年秋\", \"\", \"\", \"算法分析与设计\", \"\", \"\", \"\", \"\", \"王静\", \"\", \"\", \"1周\", 1, 3, 2, \"\", \"计算机综合楼205\", \"\"], "+
                "[\"2017-2018学年秋\", \"\", \"\", \"毛泽东思想和中国特色社会主义理论体系概论\", \"\", \"\", \"\", \"\", \"杨晓军\", \"\", \"\", \"6-12,14-17周上\", 1, 5, 2, \"\", \"3号教学楼3208\", \"\"]," +
                "[\"2017-2018学年秋\", \"\", \"\", \"高等数学提高\", \"\", \"\", \"\", \"\", \"彭波\", \"\", \"\", \"3-12周\", 1, 9, 2, \"\", \"3号教学楼3101\", \"\"], "+
                "[\"2017-2018学年秋\", \"\", \"\", \"面向对象分析与设计\", \"\", \"\", \"\", \"\", \"马永强\", \"\", \"\", \"1-8周\", 2, 1, 2, \"\", \"计算机综合楼106\", \"\"], "+
                "[\"2017-2018学年秋\", \"\", \"\", \"软件工程\", \"\", \"\", \"\", \"\", \"马永强\", \"\", \"\", \"6-12,14-18周上\", 2, 3, 2, \"\", \"计算机综合楼106\", \"\"], "+
                "[\"2017-2018学年秋\", \"\", \"\", \"Linux原理与应用\", \"\", \"\", \"\", \"\", \"刘永利\", \"\", \"\", \"9-12,14-15周上\", 2, 9, 2, \"\", \"计算机综合楼205\", \"\"], "+
                "[\"2017-2018学年秋\", \"\", \"\", \"计算机组成原理\", \"\", \"\", \"\", \"\", \"刘静\", \"\", \"\", \"8-12,14-17周上\", 3, 1, 2, \"\", \"计算机综合楼106\", \"\"], "+
                "[\"2017-2018学年秋\", \"\", \"\", \"算法分析与设计\", \"\", \"\", \"\", \"\", \"王静\", \"\", \"\", \"1-12周\", 3, 3, 2, \"\", \"计算机综合楼205\", \"\"], "+
                "[\"2017-2018学年秋\", \"\", \"\", \"毛泽东思想和中国特色社会主义理论体系概论\", \"\", \"\", \"\", \"\", \"杨晓军\", \"\", \"\", \"6-12,14-17周上\", 3, 5, 2, \"\", \"3号教学楼3208\", \"\"], "+
                "[\"2017-2018学年秋\", \"\", \"\", \"高等数学提高\", \"\", \"\", \"\", \"\", \"彭波\", \"\", \"\", \"3-4周上\", 3, 7, 2, \"\", \"3号教学楼3101\", \"\"], "+
                "[\"2017-2018学年秋\", \"\", \"\", \"数据库高级应用\", \"\", \"\", \"\", \"\", \"李国斌\", \"\", \"\", \"9-12,14-18周上\", 3, 9, 2, \"\", \"计算机综合楼202\", \"\"], "+
                "[\"2017-2018学年秋\", \"\", \"\", \"面向对象分析与设计\", \"\", \"\", \"\", \"\", \"马永强\", \"\", \"\", \"1-8周\", 4, 1, 2, \"\", \"计算机综合楼106\", \"\"], "+
                "[\"2017-2018学年秋\", \"\", \"\", \"数字图像处理\", \"\", \"\", \"\", \"\", \"王静\", \"\", \"\", \"1-10周\", 4, 3, 2, \"\", \"计算机综合楼102\", \"\"], "+
                "[\"2017-2018学年秋\", \"\", \"\", \"数据库高级应用\", \"\", \"\", \"\", \"\", \"李国斌\", \"\", \"\", \"9-12,14-18周上\", 4, 5, 2, \"\", \"计算机综合楼202\", \"\"]]";
        return parse(json);
    }

    //对json字符串进行解析
    public static List<Subject> parse(String parseString) {
        List<Subject> courses = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(parseString);
            for (int i = 0; i < array.length(); i++) {
                JSONArray array2 = array.getJSONArray(i);
                String term = array2.getString(0);
                String name = array2.getString(3);
                String teacher = array2.getString(8);
                if (array2.length() <= 10) {
                    courses.add(new Subject(term, name, null, teacher, null, -1, -1, -1, -1, null));
                    continue;
                }
                String string = array2.getString(17);
                if (string != null) {
                    string = string.replaceAll("\\(.*?\\)", "");
                }
                String room = array2.getString(16) + string;
                String weeks = array2.getString(11);
                int day, start, step;
                try {
                    day = Integer.parseInt(array2.getString(12));
                    start = Integer.parseInt(array2.getString(13));
                    step = Integer.parseInt(array2.getString(14));
                } catch (Exception e) {
                    day = -1;
                    start = -1;
                    step = -1;
                }
                courses.add(new Subject(term, name, room, teacher, getWeekList(weeks), start, step, day, -1, null));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public static List<Integer> getWeekList(String weeksString) {
        List<Integer> weekList = new ArrayList<>();
        if (weeksString == null || weeksString.length() == 0) return weekList;

        weeksString = weeksString.replaceAll("[^\\d\\-\\,]", "");
        if (weeksString.indexOf(",") != -1) {
            String[] arr = weeksString.split(",");
            for (int i = 0; i < arr.length; i++) {
                weekList.addAll(getWeekList2(arr[i]));
            }
        } else {
            weekList.addAll(getWeekList2(weeksString));
        }
        return weekList;
    }

    public static List<Integer> getWeekList2(String weeksString) {
        List<Integer> weekList = new ArrayList<>();
        int first = -1, end = -1, index = -1;
        if ((index = weeksString.indexOf("-")) != -1) {
            first = Integer.parseInt(weeksString.substring(0, index));
            end = Integer.parseInt(weeksString.substring(index + 1));
        } else {
            first = Integer.parseInt(weeksString);
            end = first;
        }
        for (int i = first; i <= end; i++)
            weekList.add(i);
        return weekList;
    }

}
