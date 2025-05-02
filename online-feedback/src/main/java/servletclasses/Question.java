package servletclasses;

public class Question {
	private int id;
	private String question_text;
	
	public Question()
	{
		
	}
	public Question(int id,String question_text)
	{
		this.id = id;
		this.question_text = question_text;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public void setQuestion(String question_text)
	{
		this.question_text = question_text;
	}
	public int getId()
	{
		return id;
	}
	public String getQuestionText()
	{
		return question_text;
	}
}
