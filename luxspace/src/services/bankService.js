import http from '../http-common';

class BankService {
    save(bankDTO) {
        return http.post("/bank/save", bankDTO);
    }
}

export default new BankService();