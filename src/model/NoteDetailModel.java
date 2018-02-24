package model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ノート詳細情報モデル
 *
 * @author ozaki
 *
 */
public class NoteDetailModel implements Serializable {

    /* ノートID */
    private String noteId;
    /* ID */
    private String userId;
    /* タグ名 */
    private String tagNm;
    /* タイトル */
    private String title;
    /* 学習ノートタイトル1 */
    private String studyNoteTitle1;
    /* 学習ノート1 */
    private String studyNote1;
    /* 学習ノートタイトル2 */
    private String studyNoteTitle2;
    /* 学習ノート2 */
    private String studyNote2;
    /* 学習ノートタイトル3 */
    private String studyNoteTitle3;
    /* 学習ノート3 */
    private String studyNote3;
    /* ToDoノートタイトル1 */
    private String todoNoteTitle1;
    /* ToDoノート1 */
    private String todoNote1;
    /* ToDoノートタイトル2 */
    private String todoNoteTitle2;
    /* ToDoノート2 */
    private String todoNote2;
    /* ToDoノートタイトル3 */
    private String todoNoteTitle3;
    /* ToDoノート3 */
    private String todoNote3;
    /* 備考 */
    private String biko;
    /* 作成日 */
    private LocalDateTime createDate;

    /**
     * 引数なしコンストラクタ
     */
    public NoteDetailModel() {

    }

    /**
     * 引数ありコンストラクタ
     *
     * @param noteId
     * @param userId
     * @param tagNm
     * @param title
     * @param studyNoteTiltle1
     * @param studyNote1
     * @param studyNoteTiltle2
     * @param studyNote2
     * @param studyNoteTiltle3
     * @param studyNote3
     * @param todoNoteTitle1
     * @param toDoNote1
     * @param todoNoteTitle2
     * @param toDoNote2
     * @param todoNoteTitle3
     * @param toDoNote3
     * @param biko
     * @param createDate
     */
    public NoteDetailModel(String noteId, String userId, String tagNm, String title, String studyNoteTiltle1,
            String studyNote1, String studyNoteTiltle2, String studyNote2, String studyNoteTiltle3, String studyNote3,
            String todoNoteTitle1, String todoNote1, String todoNoteTitle2, String todoNote2, String todoNoteTitle3,
            String todoNote3, String biko, LocalDateTime createDate) {
        this.noteId = noteId;
        this.userId = userId;
        this.tagNm = tagNm;
        this.title = title;
        this.studyNoteTitle1 = studyNoteTiltle1;
        this.studyNote1 = studyNote1;
        this.studyNoteTitle2 = studyNoteTiltle2;
        this.studyNote2 = studyNote2;
        this.studyNoteTitle3 = studyNoteTiltle3;
        this.studyNote3 = studyNote3;
        this.todoNoteTitle1 = todoNoteTitle1;
        this.todoNote1 = todoNote1;
        this.todoNoteTitle2 = todoNoteTitle2;
        this.todoNote2 = todoNote2;
        this.todoNoteTitle3 = todoNoteTitle3;
        this.todoNote3 = todoNote3;
        this.biko = biko;
        this.createDate = createDate;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTagNm() {
        return tagNm;
    }

    public void setTagNm(String tagNm) {
        this.tagNm = tagNm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStudyNoteTitle1() {
        return studyNoteTitle1;
    }

    public void setStudyNoteTitle1(String studyNoteTitle1) {
        this.studyNoteTitle1 = studyNoteTitle1;
    }

    public String getStudyNote1() {
        return studyNote1;
    }

    public void setStudyNote1(String studyNote1) {
        this.studyNote1 = studyNote1;
    }

    public String getStudyNoteTitle2() {
        return studyNoteTitle2;
    }

    public void setStudyNoteTitle2(String studyNoteTitle2) {
        this.studyNoteTitle2 = studyNoteTitle2;
    }

    public String getStudyNote2() {
        return studyNote2;
    }

    public void setStudyNote2(String studyNote2) {
        this.studyNote2 = studyNote2;
    }

    public String getStudyNoteTitle3() {
        return studyNoteTitle3;
    }

    public void setStudyNoteTitle3(String studyNoteTitle3) {
        this.studyNoteTitle3 = studyNoteTitle3;
    }

    public String getStudyNote3() {
        return studyNote3;
    }

    public void setStudyNote3(String studyNote3) {
        this.studyNote3 = studyNote3;
    }

    public String getTodoNoteTitle1() {
        return todoNoteTitle1;
    }

    public void setTodoNoteTitle1(String todoNoteTitle1) {
        this.todoNoteTitle1 = todoNoteTitle1;
    }

    public String getTodoNote1() {
        return todoNote1;
    }

    public void setTodoNote1(String todoNote1) {
        this.todoNote1 = todoNote1;
    }

    public String getTodoNoteTitle2() {
        return todoNoteTitle2;
    }

    public void setTodoNoteTitle2(String todoNoteTitle2) {
        this.todoNoteTitle2 = todoNoteTitle2;
    }

    public String getTodoNote2() {
        return todoNote2;
    }

    public void setTodoNote2(String todoNote2) {
        this.todoNote2 = todoNote2;
    }

    public String getTodoNoteTitle3() {
        return todoNoteTitle3;
    }

    public void setTodoNoteTitle3(String todoNoteTitle3) {
        this.todoNoteTitle3 = todoNoteTitle3;
    }

    public String getTodoNote3() {
        return todoNote3;
    }

    public void setTodoNote3(String todoNote3) {
        this.todoNote3 = todoNote3;
    }

    public String getBiko() {
        return biko;
    }

    public void setBiko(String biko) {
        this.biko = biko;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

}
