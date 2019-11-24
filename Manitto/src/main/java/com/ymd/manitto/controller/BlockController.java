package com.ymd.manitto.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import com.ymd.manitto.block.Manitto;
import com.ymd.manitto.service.FcmService;
import com.ymd.manitto.service.MSGService;
import com.ymd.manitto.utils.StringUtils;

@Controller
public class BlockController {

	@Autowired
	StringUtils utils;
	@Autowired
	FcmService ser;
	@Autowired
	MSGService msgser;

	private List<CompletableFuture> futures = new ArrayList<>();

	public static final int NETWORK_ID_MAIN = 1;
	public static final int NETWORK_ID_ROPSTEN = 3;
	public static String infuraAccessToken = "4b260a0a46c7450886b982ac0ca0b9a8";
	public static String infuraTestNetRopstenUrl = "https://ropsten.infura.io/v3/" + infuraAccessToken;

	private static final Logger logger = LoggerFactory.getLogger(BlockController.class);

	@RequestMapping(value = "/block", method = RequestMethod.GET)
	public String block(Model model, Locale locale) {
		logger.debug("block");
		Web3j web3 = Web3j.build(new HttpService(infuraTestNetRopstenUrl)); // defaults to http://localhost:8545/
		Web3ClientVersion web3ClientVersion;
		String clientVersion = "";
		try {
			web3ClientVersion = web3.web3ClientVersion().send();
			clientVersion = web3ClientVersion.getWeb3ClientVersion();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.debug("block");
		model.addAttribute("clientVersion", clientVersion);

		return "block";
	}


	@RequestMapping(value = "/getIndex", method = RequestMethod.GET)
	public String getIndex(Model model, Locale locale) throws Exception {
		logger.debug("block");
	    Credentials credentials = getCredentials();
		Web3j web3 = Web3j.build(new HttpService(infuraTestNetRopstenUrl)); //
		String contractAddress = "0x4951f8f5E231FD3E56919a1d43B4b23416f3Ab4B";
		Manitto manittoContract = Manitto.load(contractAddress, web3, credentials, Manitto.GAS_PRICE,
				Manitto.GAS_LIMIT);
		boolean valid = manittoContract.isValid();
		
		CompletableFuture<BigInteger> index=manittoContract.getIndex().sendAsync();
		logger.debug(index.get().toString());
		
//		RemoteFunctionCall<BigInteger> index=manittoContract.getIndex();
//		CompletableFuture<BigInteger> getIndex= index.sendAsync();	
//		futures.add(getIndex); 
		//((CompletableFuture) futures).thenAccept(r->r.);
		
		// String kinContractName = _kinContract.name().get().getValue();

		return "manitto";
	}

	@RequestMapping(value = "/getRanking", method = RequestMethod.GET)
	public String getRanking(Model model, Locale locale) {
		try {
		logger.debug("test");
		logger.debug(System.getProperty("user.dir"));
		
		}catch(Exception e) {
			logger.debug(e.toString());
		}
		

		return "block";
	}
	
	@RequestMapping(value = "/insertUserInfo", method = RequestMethod.GET)
	public String insertUserInfo(Model model, Locale locale) throws Exception{
		
		Credentials credentials = getCredentials();
		Web3j web3 = Web3j.build(new HttpService(infuraTestNetRopstenUrl)); //
		String contractAddress = "0x4951f8f5E231FD3E56919a1d43B4b23416f3Ab4B";
		Manitto manittoContract = Manitto.load(contractAddress, web3, credentials, Manitto.GAS_PRICE,
					Manitto.GAS_LIMIT);
		BigInteger bi =BigInteger.valueOf(5);
		RemoteFunctionCall<TransactionReceipt> receipt=manittoContract.insertRanking("cha", "kim", bi, bi);
		logger.debug("receipt"+receipt.sendAsync());
		
		return "block";
	}
	
	public Credentials getCredentials() throws Exception {
		String password ="youmanda123!";
		String walletFile="UTC--2019-11-24T04-42-23.564338600Z--9bc760adecff33b971f8823a502eaa52555d3934";
		String path ="C:/Users/501-1/git/HGRmanitto3/Manitto/src/main/java/com/ymd/manitto/wallet"; 
		String credentialPath = path + "/" + walletFile;
		return WalletUtils.loadCredentials(password, credentialPath);

	}

}
