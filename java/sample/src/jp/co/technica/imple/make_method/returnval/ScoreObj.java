package jp.co.technica.imple.make_method.returnval;

public class ScoreObj {
	public ObjPtn getObj(String name){
		if( (name==null) || (name.length() == 0)){
		return new SubObjPtnNull(name);
		}
		return new SubObjPtn(name);
	}
}
