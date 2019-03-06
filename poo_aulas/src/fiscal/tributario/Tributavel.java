package fiscal.tributario;

public abstract class Tributavel { 
	double value;
	
	public Tributavel(double _value){
		this.value = _value;
	}
	public double valor() {
		return value;
	}
} 
