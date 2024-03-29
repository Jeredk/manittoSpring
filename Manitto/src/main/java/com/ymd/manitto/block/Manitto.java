package com.ymd.manitto.block;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.7.
 */
@SuppressWarnings("rawtypes")
public class Manitto extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50600080546001600160a01b0319163317905561066b806100326000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806322c1062b1461004657806381045ead14610185578063bea2dc141461019f575b600080fd5b6101836004803603608081101561005c57600080fd5b81019060208101813564010000000081111561007757600080fd5b82018360208201111561008957600080fd5b803590602001918460018302840111640100000000831117156100ab57600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092959493602081019350359150506401000000008111156100fe57600080fd5b82018360208201111561011057600080fd5b8035906020019184600183028401116401000000008311171561013257600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295505060ff83358116945060209093013590921691506102ae9050565b005b61018d61039e565b60408051918252519081900360200190f35b6101bc600480360360208110156101b557600080fd5b50356103a4565b6040805160ff80851692820192909252908216606082015260808082528551908201528451819060208083019160a084019189019080838360005b8381101561020f5781810151838201526020016101f7565b50505050905090810190601f16801561023c5780820380516001836020036101000a031916815260200191505b50838103825286518152865160209182019188019080838360005b8381101561026f578181015183820152602001610257565b50505050905090810190601f16801561029c5780820380516001836020036101000a031916815260200191505b50965050505050505060405180910390f35b6000546001600160a01b031633146102c557610398565b6102cd61056d565b5060408051608081018252858152602080820186905260ff808616938301939093529183166060820152600180548082018083556000929092528251805193949293859360039093027fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf6019261034792849291019061059b565b506020828101518051610360926001850192019061059b565b5060408201516002909101805460609093015160ff9081166101000261ff00199190931660ff19909416939093179290921617905550505b50505050565b60015490565b606080600080600185815481106103b757fe5b6000918252602091829020600390910201805460408051601f600260001961010060018716150201909416939093049283018590048502810185019091528181529283018282801561044a5780601f1061041f5761010080835404028352916020019161044a565b820191906000526020600020905b81548152906001019060200180831161042d57829003601f168201915b505050505093506001858154811061045e57fe5b90600052602060002090600302016001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105035780601f106104d857610100808354040283529160200191610503565b820191906000526020600020905b8154815290600101906020018083116104e657829003601f168201915b505050505092506001858154811061051757fe5b906000526020600020906003020160020160009054906101000a900460ff1691506001858154811061054557fe5b906000526020600020906003020160020160019054906101000a900460ff1690509193509193565b60405180608001604052806060815260200160608152602001600060ff168152602001600060ff1681525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106105dc57805160ff1916838001178555610609565b82800160010185558215610609579182015b828111156106095782518255916020019190600101906105ee565b50610615929150610619565b5090565b61063391905b80821115610615576000815560010161061f565b9056fea265627a7a723158203a84fb9f0c1c9c9a8983b579ee215a9b3e5b8cd204006bac0058295a03a135ea64736f6c634300050d0032";

    public static final String FUNC_GETINDEX = "getIndex";

    public static final String FUNC_GETRANKING = "getRanking";

    public static final String FUNC_INSERTRANKING = "insertRanking";

    @Deprecated
    protected Manitto(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Manitto(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Manitto(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Manitto(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> getIndex() {
        final Function function = new Function(FUNC_GETINDEX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple4<String, String, BigInteger, BigInteger>> getRanking(BigInteger index) {
        final Function function = new Function(FUNC_GETRANKING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Uint8>() {}));
        return new RemoteFunctionCall<Tuple4<String, String, BigInteger, BigInteger>>(function,
                new Callable<Tuple4<String, String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple4<String, String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, String, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> insertRanking(String userName, String date, BigInteger likeCount, BigInteger best) {
        final Function function = new Function(
                FUNC_INSERTRANKING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(userName), 
                new org.web3j.abi.datatypes.Utf8String(date), 
                new org.web3j.abi.datatypes.generated.Uint8(likeCount), 
                new org.web3j.abi.datatypes.generated.Uint8(best)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Manitto load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Manitto(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Manitto load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Manitto(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Manitto load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Manitto(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Manitto load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Manitto(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Manitto> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Manitto.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Manitto> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Manitto.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Manitto> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Manitto.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Manitto> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Manitto.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
