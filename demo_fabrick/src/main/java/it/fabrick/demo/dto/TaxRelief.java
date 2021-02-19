package it.fabrick.demo.dto;

public class TaxRelief {
	
	private String taxReliefId;
	private Boolean isCondoUpgrade;
	private String creditorFiscalCode;
	private String beneficiaryType;
	private NaturalPersonBenificiary naturalPersonBeneficiary;
	private LegalPersonBenificiary legalPersonBenificiary;
	
	public String getTaxReliefId() {
		return taxReliefId;
	}
	public void setTaxReliefId(String taxReliefId) {
		this.taxReliefId = taxReliefId;
	}
	public Boolean getIsCondoUpgrade() {
		return isCondoUpgrade;
	}
	public void setIsCondoUpgrade(Boolean isCondoUpgrade) {
		this.isCondoUpgrade = isCondoUpgrade;
	}
	public String getCreditorFiscalCode() {
		return creditorFiscalCode;
	}
	public void setCreditorFiscalCode(String creditorFiscalCode) {
		this.creditorFiscalCode = creditorFiscalCode;
	}
	public String getBeneficiaryType() {
		return beneficiaryType;
	}
	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}
	public NaturalPersonBenificiary getNaturalPersonBeneficiary() {
		return naturalPersonBeneficiary;
	}
	public void setNaturalPersonBeneficiary(NaturalPersonBenificiary naturalPersonBeneficiary) {
		this.naturalPersonBeneficiary = naturalPersonBeneficiary;
	}
	public LegalPersonBenificiary getLegalPersonBenificiary() {
		return legalPersonBenificiary;
	}
	public void setLegalPersonBenificiary(LegalPersonBenificiary legalPersonBenificiary) {
		this.legalPersonBenificiary = legalPersonBenificiary;
	}
	
	
}
