package application.service

import application.model.DepositRequest
import application.usecase.DepositUseCase
import domain.client.Client
import domain.client.ClientRepository
import domain.client.account.money.Money
import infrastructure.client.ClientRepositoryImpl

class DepositService implements DepositUseCase{

    ClientRepository clientRepository

    DepositService(){
        clientRepository = new ClientRepositoryImpl()
    }

    @Override
    void cashDeposit(DepositRequest request){
        Client.ClientId clientId = new Client.ClientId(request.clientId)
        Client client = clientRepository.find(clientId)
        assert client
        Money money = Money.dollar(request.money.amount)
        client.deposit(money)
        clientRepository.add(client) //TODO: Tendria que ser update
    }
}
