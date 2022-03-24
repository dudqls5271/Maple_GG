package linkUnion;

import javafx.beans.property.StringProperty;

public class linkVO {
    private StringProperty job;
    private StringProperty skill;
    private StringProperty effect;
 
    public linkVO(StringProperty job, StringProperty skill, StringProperty effect) {
        this.job = job;
        this.skill = skill;
        this.effect = effect;
    }
	public StringProperty jobProperty() {
        return job;
    }
    public StringProperty skillProperty() {
        return skill;
    }
    public StringProperty effectProperty() {
        return effect;
    }
    
    


}

//skillMap
//effectMap