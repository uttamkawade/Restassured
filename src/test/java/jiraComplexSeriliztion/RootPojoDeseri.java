package jiraComplexSeriliztion;

import java.util.Date;

public class RootPojoDeseri {
	
	private String self;
    private String id;
    private Author author;
    private String body;
    private UpdateAuthor updateAuthor;
    private Date created;
    private Date updated;
    private Visibility visibility;
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public UpdateAuthor getUpdateAuthor() {
		return updateAuthor;
	}
	public void setUpdateAuthor(UpdateAuthor updateAuthor) {
		this.updateAuthor = updateAuthor;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Visibility getVisibility() {
		return visibility;
	}
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}
    
    

}
