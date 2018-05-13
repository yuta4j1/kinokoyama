package model;

import java.time.LocalDateTime;

/**
 * studyノートBean定義クラス
 *
 * @author ozaki
 *
 */
public class StudyNoteModel {

    /* ノートID */
    private String noteId;
    private String addNoteTitle;
    private String addNoteAuthor;
    private String userId;
    private String categoryTag;
    private String studyNote1;
    private String studyNote2;
    private String studyNote3;
    private String studyNote4;
    private String studyNote5;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getAddNoteTitle() {
        return addNoteTitle;
    }

    public void setAddNoteTitle(String addNoteTitle) {
        this.addNoteTitle = addNoteTitle;
    }

    public String getAddNoteAuthor() {
        return addNoteAuthor;
    }

    public void setAddNoteAuthor(String addNoteAuthor) {
        this.addNoteAuthor = addNoteAuthor;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCategoryTag() {
        return categoryTag;
    }

    public void setCategoryTag(String categoryTag) {
        this.categoryTag = categoryTag;
    }

    public String getStudyNote1() {
        return studyNote1;
    }

    public void setStudyNote1(String studyNote1) {
        this.studyNote1 = studyNote1;
    }

    public String getStudyNote2() {
        return studyNote2;
    }

    public void setStudyNote2(String studyNote2) {
        this.studyNote2 = studyNote2;
    }

    public String getStudyNote3() {
        return studyNote3;
    }

    public void setStudyNote3(String studyNote3) {
        this.studyNote3 = studyNote3;
    }

    public String getStudyNote4() {
        return studyNote4;
    }

    public void setStudyNote4(String studyNote4) {
        this.studyNote4 = studyNote4;
    }

    public String getStudyNote5() {
        return studyNote5;
    }

    public void setStudyNote5(String studyNote5) {
        this.studyNote5 = studyNote5;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }



    /**
     * コンストラクタ
     */
    public StudyNoteModel(){
    }



}
