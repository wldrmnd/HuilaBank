package menu;

import entity.Amount;
import entity.CardHolder;
import entity.Transaction;
import entity.TransactionTime;
import repo.TransactionRepo;
import service.TransactionService;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class BankMenu {

    private TransactionRepo transactionRepo;
    private TransactionService transactionService;
    Scanner in;

    public BankMenu(){

        transactionService = new TransactionService();
        printBank();

    }

    private void printBank() {
        System.out.println("Привет! Ты попал в хуевый банк!");
        System.out.println("1. Добавить платёж");
        System.out.println("2. Вывести все платежи");
        pressUserFromConsole();
        printBank();

    }

    private void pressUserFromConsole() {
        Scanner in = new Scanner(System.in);
        int userInput = in.nextInt();

        if (userInput == 1){
            Transaction transaction = userInputFromConsole();
            transactionService.addTransaction(transaction);
        }

        if (userInput == 2){
            printTransactions(transactionService.getAll());
        }
    }

    private void printTransactions(List<Transaction> all) {
        for (Transaction transaction : all){
            System.out.println(transaction.toString());
        }
    }

    private Transaction userInputFromConsole() {
        Scanner in = new Scanner(System.in);
        Transaction transaction = new Transaction();

        transaction.setId(new Long(8));
        transaction.setTypeOfPayment("Visa");

        transaction.setAmount(new Amount('$', 55.5));
        transaction.setCardHolder(new CardHolder("Pavel", "Rud"));

        transaction.setTime(new TransactionTime(new GregorianCalendar(2015, 01, 05),
                (new GregorianCalendar(2020, 6, 01))));

        return transaction;
    }
}
