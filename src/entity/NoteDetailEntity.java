package entity;

import java.time.LocalDateTime;

public class NoteDetailEntity {

    /* ノートID */
    private String noteId;
    /* ID */
    private String userId;
    /* タグ名 */
    private String tagNm;
    /* タイトル */
    private String title;
    /* 学習ノートタイトル1 */
    private String studyNoteTiltle1;
    /* 学習ノート1 */
    private String studyNote1;
    /* 学習ノートタイトル2 */
    private String studyNoteTiltle2;
    /* 学習ノート2 */
    private String studyNote2;
    /* 学習ノートタイトル3 */
    private String studyNoteTiltle3;
    /* 学習ノート3 */
    private String studyNote3;
    /* ToDoノートタイトル1 */
    private String todoNoteTitle1;
    /* ToDoノート1 */
    private String toDoNote1;
    /* ToDoノートタイトル2 */
    private String todoNoteTitle2;
    /* ToDoノート2 */
    private String toDoNote2;
    /* ToDoノートタイトル3 */
    private String todoNoteTitle3;
    /* ToDoノート3 */
    private String toDoNote3;
    /* 備考 */
    private String biko;
    /* 作成日 */
    private LocalDateTime createDate;

    /**
     * 引数なしコンストラクタ
     */
    public NoteDetailEntity() {

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
    public NoteDetailEntity(String noteId, String userId, String tagNm, String title, String studyNoteTiltle1,
            String studyNote1, String studyNoteTiltle2, String studyNote2, String studyNoteTiltle3, String studyNote3,
            String todoNoteTitle1, String toDoNote1, String todoNoteTitle2, String toDoNote2, String todoNoteTitle3,
            String toDoNote3, String biko, LocalDateTime createDate) {
        this.noteId = noteId;
        this.userId = userId;
        this.tagNm = tagNm;
        this.title = title;
        this.studyNoteTiltle1 = studyNoteTiltle1;
        this.studyNote1 = studyNote1;
        this.studyNoteTiltle2 = studyNoteTiltle2;
        this.studyNote2 = studyNote2;
        this.studyNoteTiltle3 = studyNoteTiltle3;
        this.studyNote3 = studyNote3;
        this.todoNoteTitle1 = todoNoteTitle1;
        this.toDoNote1 = toDoNote1;
        this.todoNoteTitle2 = todoNoteTitle2;
        this.toDoNote2 = toDoNote2;
        this.todoNoteTitle3 = todoNoteTitle3;
        this.toDoNote3 = toDoNote3;
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

    public String getStudyNoteTiltle1() {
        return studyNoteTiltle1;
    }

    public void setStudyNoteTiltle1(String studyNoteTiltle1) {
        this.studyNoteTiltle1 = studyNoteTiltle1;
    }

    public String getStudyNote1() {
        return studyNote1;
    }

    public void setStudyNote1(String studyNote1) {
        this.studyNote1 = studyNote1;
    }

    public String getStudyNoteTiltle2() {
        return studyNoteTiltle2;
    }

    public void setStudyNoteTiltle2(String studyNoteTiltle2) {
        this.studyNoteTiltle2 = studyNoteTiltle2;
    }

    public String getStudyNote2() {
        return studyNote2;
    }

    public void setStudyNote2(String studyNote2) {
        this.studyNote2 = studyNote2;
    }

    public String getStudyNoteTiltle3() {
        return studyNoteTiltle3;
    }

    public void setStudyNoteTiltle3(String studyNoteTiltle3) {
        this.studyNoteTiltle3 = studyNoteTiltle3;
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

    public String getToDoNote1() {
        return toDoNote1;
    }

    public void setToDoNote1(String toDoNote1) {
        this.toDoNote1 = toDoNote1;
    }

    public String getTodoNoteTitle2() {
        return todoNoteTitle2;
    }

    public void setTodoNoteTitle2(String todoNoteTitle2) {
        this.todoNoteTitle2 = todoNoteTitle2;
    }

    public String getToDoNote2() {
        return toDoNote2;
    }

    public void setToDoNote2(String toDoNote2) {
        this.toDoNote2 = toDoNote2;
    }

    public String getTodoNoteTitle3() {
        return todoNoteTitle3;
    }

    public void setTodoNoteTitle3(String todoNoteTitle3) {
        this.todoNoteTitle3 = todoNoteTitle3;
    }

    public String getToDoNote3() {
        return toDoNote3;
    }

    public void setToDoNote3(String toDoNote3) {
        this.toDoNote3 = toDoNote3;
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
