package com.example.grpcserverspring2_7

import com.example.grpcclienttest.model.protobuf.MyServiceGrpc
import com.example.grpcclienttest.model.protobuf.Req
import com.example.grpcclienttest.model.protobuf.Res
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService

@GrpcService
class GrpcPingPongService : MyServiceGrpc.MyServiceImplBase() {
    override fun pingPong(request: Req?, responseObserver: StreamObserver<Res>?) {
        println(request?.message)
        val res = Res.newBuilder()
            .setMessage("pong")
            .build()
        responseObserver?.onNext(res)
        responseObserver?.onCompleted()
    }
}
