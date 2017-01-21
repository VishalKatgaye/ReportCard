package com.vishalkatgaye.reportcard;

import java.util.ArrayList;

/**
 * Created by ViSh on 21-01-2017.
 * <p>
 * ReportCard class is used to generate report card.
 */

public class ReportCard {

    /* TOTAL variable is a constant field and it will be used as total marks*/
    private final int TOTAL = 100;

    private String mGrade;

    private ArrayList<String> mSubjects;

    private ArrayList<Integer> mMarks;

    private String mRemark;

    /**
     * Below data will generate Report card for all subjects.
     *
     * @param subjects contains subject list.
     * @param marks    contains marks obtained in the subjects.
     */
    public ReportCard(ArrayList<String> subjects, ArrayList<Integer> marks) {
        if (subjects.size() == marks.size()) {
            this.mSubjects = subjects;
            this.mMarks = marks;
        } else
            throw new java.lang.IllegalArgumentException("Incompatible ArrayList length");
    }

    /**
     * This is non-parameterize constructor.
     */
    public ReportCard() {
    }

    /**
     * @return returns given remark.
     */
    public String getRemark() {
        return mRemark;
    }

    /**
     * @param remark contains given remark and update the given remark.
     */
    public void setRemark(String remark) {
        this.mRemark = remark;
    }

    /**
     * @return returns subject list.
     */
    public ArrayList<String> getSubjects() {
        return mSubjects;
    }

    /**
     * @param subjects given will be stored.
     */
    public void setSubjects(ArrayList<String> subjects) {
        this.mSubjects = subjects;
    }

    /**
     * @return Returns the total marks.
     */
    public int getTotalMarks() {
        int sum = 0;
        for (int sub_length = 0; sub_length < mMarks.size(); sub_length++) {
            sum = sum + mMarks.get(sub_length);
            if (mMarks.get(sub_length) < 35) {
                mGrade = "F";
                mRemark = "Failed! try again harder";
            }
        }
        return sum;
    }

    /**
     * @param mMarks aquire subject marks.
     */
    public void setTotalMarks(ArrayList<Integer> mMarks) {
        this.mMarks = mMarks;
    }

    /**
     * @return returns the grade of the student with auto generated remark.
     */
    public String getGrade() {
        int totalMarks = getTotalMarks();
        double average = (totalMarks * 100) / (TOTAL * mSubjects.size());

        if (average >= 90 && average <= 100 && mGrade != "F") {
            mGrade = "A+";
            mRemark = "Excellent! Passed with Merit";
        } else if (average >= 75 && mGrade != "F") {
            mGrade = "A";
            mRemark = "Good! Passed with Distinction";
        } else if (average >= 60 && mGrade != "F") {
            mGrade = "B+";
            mRemark = "Good! Passed";
        } else if (average >= 50 && mGrade != "F") {
            mGrade = "B";
            mRemark = "You are in Progress! Passed";
        } else if (average >= 45 && mGrade != "F") {
            mGrade = "C+";
            mRemark = "Very low prgress! Passed";
        } else if (average >= 35 && mGrade != "F") {
            mGrade = "D";
            mRemark = "Passed in edge";
        } else {
            mGrade = "F";
            mRemark = "Failed! try again harder";
        }
        return mGrade;
    }

    @Override
    public String toString() {
        return "Total Marks : " + getTotalMarks() + "\n" +
                "Grade : " + getGrade() + "\n" +
                "Remark : " + getRemark();
    }
}