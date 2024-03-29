package com.example.education.objects;


import com.zhuangfei.timetable.model.Schedule;
import com.zhuangfei.timetable.model.ScheduleEnable;

import java.util.List;

public class Subject implements ScheduleEnable {
    public static final String EXTRAS_ID = "extras_id";

    private int id = 0;

    //课程名
    private String name;

    //无用数据
    private String time;

    //教室
    private String room;

    //教师
    private String teacher;

    //第几周至第几周
    private List<Integer> weekList;

    //开始上课的节次
    private int start;

    //上课节数
    private int step;

    //星期几
    private int day;

    private String term;

    //对应课程颜色的随机数
    private int colorRandom = 0;

    private String url;

    public Subject() {
        // TODO Auto-generated constructor stub
    }

    public Subject(String term, String name, String room, String teacher, List<Integer> weekList, int start, int step, int day, int colorRandom, String time) {
        super();
        this.term = term;
        this.name = name;
        this.room = room;
        this.teacher = teacher;
        this.weekList = weekList;
        this.start = start;
        this.step = step;
        this.day = day;
        this.colorRandom = colorRandom;
        this.time = time;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setWeekList(List<Integer> weekList) {
        this.weekList = weekList;
    }

    public List<Integer> getWeekList() {
        return weekList;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getColorRandom() {
        return colorRandom;
    }

    public void setColorRandom(int colorRandom) {
        this.colorRandom = colorRandom;
    }

    @Override
    public Schedule getSchedule() {
        Schedule schedule = new Schedule();
        schedule.setDay(getDay());
        schedule.setName(getName());
        schedule.setRoom(getRoom());
        schedule.setStart(getStart());
        schedule.setStep(getStep());
        schedule.setTeacher(getTeacher());
        schedule.setWeekList(getWeekList());
        schedule.setColorRandom(2);
        schedule.putExtras(EXTRAS_ID, getId());
        return schedule;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
