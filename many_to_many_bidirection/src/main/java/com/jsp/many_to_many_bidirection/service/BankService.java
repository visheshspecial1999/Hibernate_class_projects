package com.jsp.many_to_many_bidirection.service;

import java.util.List;

import com.jsp.many_to_many_bidirection.dao.BankDao;
import com.jsp.many_to_many_bidirection.dto.Bank;

public class BankService {
	
	BankDao dao=new BankDao();
	// insertBank method
		public void insertBank(Bank bank) {
			dao.insertBank(bank);
		}
		
		// searchBank method
		public Bank searchBank(int bankId) {
			return dao.searchBank(bankId);
		}

		// updateBank method
		public void updateBank(Bank bank) {
			Bank bank2=dao.searchBank(bank.getBankId());
			if(bank2!=null) {
				dao.updateBank(bank);
			}
			else {
				System.out.println("bankId is  not present in database");
			}
		}

		// deleteBank method
		public void deleteBank(int bankId) {
			Bank bank=dao.searchBank(bankId);
			if(bank!=null) {
				dao.deleteBank(bankId);
			}
			else {
				System.out.println("bankId is not present or already has been deleted");
			}
		}
		
		// displayBank method
		public List<Bank> displayBank(){
		return	dao.displayBank();
		}
		
}
