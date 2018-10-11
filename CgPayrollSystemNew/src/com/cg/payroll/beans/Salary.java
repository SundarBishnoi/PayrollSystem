package com.cg.payroll.beans;
public class Salary {
	private float basicSalary,hra,conveyneceAllowance,otherAllowance,personalAllownace,
	monthlyTax,epf,companyPf,gratuity,grossSalary,netsalary;
	public Salary() {
		super();
	}
	public Salary(float basicSalary, float hra, float conveyneceAllowance,
			float otherAllowance, float personalAllownace, float monthlyTax,
			float epf, float companyPf, float gratuity, float grossSalary,
			float netsalary) {
		super();
		this.basicSalary = basicSalary;
		this.hra = hra;
		this.conveyneceAllowance = conveyneceAllowance;
		this.otherAllowance = otherAllowance;
		this.personalAllownace = personalAllownace;
		this.monthlyTax = monthlyTax;
		this.epf = epf;
		this.companyPf = companyPf;
		this.gratuity = gratuity;
		this.grossSalary = grossSalary;
		this.netsalary = netsalary;
	}
	public Salary(float basicSalary, float epf, float companyPf) {
		super();
		this.basicSalary = basicSalary;
		this.epf = epf;
		this.companyPf = companyPf;
	}
	public float getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	public float getHra() {
		return hra;
	}
	public void setHra(float hra) {
		this.hra = hra;
	}
	public float getConveyneceAllowance() {
		return conveyneceAllowance;
	}
	public void setConveyneceAllowance(float conveyneceAllowance) {
		this.conveyneceAllowance = conveyneceAllowance;
	}
	public float getOtherAllowance() {
		return otherAllowance;
	}
	public void setOtherAllowance(float otherAllowance) {
		this.otherAllowance = otherAllowance;
	}
	public float getPersonalAllownace() {
		return personalAllownace;
	}
	public void setPersonalAllownace(float personalAllownace) {
		this.personalAllownace = personalAllownace;
	}
	public float getMonthlyTax() {
		return monthlyTax;
	}
	public void setMonthlyTax(float monthlyTax) {
		this.monthlyTax = monthlyTax;
	}
	public float getEpf() {
		return epf;
	}
	public void setEpf(float epf) {
		this.epf = epf;
	}
	public float getCompanypf() {
		return companyPf;
	}
	public void setCompanypf(float companyPf) {
		this.companyPf = companyPf;
	}
	public float getGratuity() {
		return gratuity;
	}
	public void setGratuity(float gratuity) {
		this.gratuity = gratuity;
	}
	public float getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(float grossSalary) {
		this.grossSalary = grossSalary;
	}
	public float getNetsalary() {
		return netsalary;
	}
	public void setNetsalary(float netsalary) {
		this.netsalary = netsalary;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(basicSalary);
		result = prime * result + Float.floatToIntBits(companyPf);
		result = prime * result + Float.floatToIntBits(conveyneceAllowance);
		result = prime * result + Float.floatToIntBits(epf);
		result = prime * result + Float.floatToIntBits(gratuity);
		result = prime * result + Float.floatToIntBits(grossSalary);
		result = prime * result + Float.floatToIntBits(hra);
		result = prime * result + Float.floatToIntBits(monthlyTax);
		result = prime * result + Float.floatToIntBits(netsalary);
		result = prime * result + Float.floatToIntBits(otherAllowance);
		result = prime * result + Float.floatToIntBits(personalAllownace);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salary other = (Salary) obj;
		if (Float.floatToIntBits(basicSalary) != Float
				.floatToIntBits(other.basicSalary))
			return false;
		if (Float.floatToIntBits(companyPf) != Float
				.floatToIntBits(other.companyPf))
			return false;
		if (Float.floatToIntBits(conveyneceAllowance) != Float
				.floatToIntBits(other.conveyneceAllowance))
			return false;
		if (Float.floatToIntBits(epf) != Float.floatToIntBits(other.epf))
			return false;
		if (Float.floatToIntBits(gratuity) != Float
				.floatToIntBits(other.gratuity))
			return false;
		if (Float.floatToIntBits(grossSalary) != Float
				.floatToIntBits(other.grossSalary))
			return false;
		if (Float.floatToIntBits(hra) != Float.floatToIntBits(other.hra))
			return false;
		if (Float.floatToIntBits(monthlyTax) != Float
				.floatToIntBits(other.monthlyTax))
			return false;
		if (Float.floatToIntBits(netsalary) != Float
				.floatToIntBits(other.netsalary))
			return false;
		if (Float.floatToIntBits(otherAllowance) != Float
				.floatToIntBits(other.otherAllowance))
			return false;
		if (Float.floatToIntBits(personalAllownace) != Float
				.floatToIntBits(other.personalAllownace))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Salary [basicSalary=" + basicSalary + ", hra=" + hra
				+ ", conveyneceAllowance=" + conveyneceAllowance
				+ ", otherAllowance=" + otherAllowance + ", personalAllownace="
				+ personalAllownace + ", monthlyTax=" + monthlyTax + ", epf="
				+ epf + ", companypf=" + companyPf + ", gratuity=" + gratuity
				+ ", grossSalary=" + grossSalary + ", netsalary=" + netsalary
				+ "]";
	}
}
