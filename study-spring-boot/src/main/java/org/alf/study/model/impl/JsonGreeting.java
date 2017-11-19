package org.alf.study.model.impl;

import org.alf.study.model.Greeting;

public class JsonGreeting implements Greeting {

    private long id;
    private String content;

    public JsonGreeting() {
	}
    
    public JsonGreeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getContent() {
        return content;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JsonGreeting [id=").append(id).append(", ");
		if (content != null)
			builder.append("content=").append(content);
		builder.append("]");
		return builder.toString();
	}

}