package ma.ensaj.hotel.controller.grpc;

import io.grpc.stub.StreamObserver;
import ma.ensaj.hotel.repository.ChambreRepository;
import ma.ensaj.hotel.repository.ClientRepository;
import ma.ensaj.hotel.stubs.ReservationServiceGrpc;
import ma.ensaj.hotel.stubs.ReservationProto;
import ma.ensaj.hotel.service.ReservationService;
import ma.ensaj.hotel.entity.Client;
import ma.ensaj.hotel.entity.Chambre;
import ma.ensaj.hotel.entity.Reservation;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class ReservationServiceGrpcImpl extends ReservationServiceGrpc.ReservationServiceImplBase {
    @Autowired
    private  ReservationService reservationService;
    @Autowired
    private  ChambreRepository chambreRepository;
    @Autowired
    private  ClientRepository clientRepository;


    @Override
    public void createReservation(ReservationProto.CreateReservationRequest request,
                                  StreamObserver<ReservationProto.CreateReservationResponse> responseObserver) {
        // Extract the reservation details from the request
        var grpcReservation = request.getReservation();

        // Convert gRPC Reservation to entity
        Reservation reservation = new Reservation();
        reservation.setClient(new Client(
                grpcReservation.getClient().getId(),
                grpcReservation.getClient().getNom(),
                grpcReservation.getClient().getPrenom(),
                grpcReservation.getClient().getEmail(),
                grpcReservation.getClient().getTelephone()
        ));
        reservation.setChambre(new Chambre(
                grpcReservation.getChambre().getId(),
                grpcReservation.getChambre().getType(),
                grpcReservation.getChambre().getPrix(),
                grpcReservation.getChambre().getDisponible()
        ));
        reservation.setDateDebut(grpcReservation.getDateDebut());
        reservation.setDateFin(grpcReservation.getDateFin());
        reservation.setPreferences(grpcReservation.getPreferences());

        // Save the reservation
        reservationService.saveReservation(reservation);

        // Create the response
        var response = ReservationProto.CreateReservationResponse.newBuilder()
                .setMessage("Reservation successfully created for client: " + grpcReservation.getClient().getNom())
                .build();

        // Send the response
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void addClient(ReservationProto.AddClientRequest request,
                          StreamObserver<ReservationProto.AddClientResponse> responseObserver) {
        // Extract client from request
        var grpcClient = request.getClient();

        // Map gRPC client to entity
        Client client = new Client();
        client.setNom(grpcClient.getNom());
        client.setPrenom(grpcClient.getPrenom());
        client.setEmail(grpcClient.getEmail());
        client.setTelephone(grpcClient.getTelephone());

        // Save to database
        clientRepository.save(client);

        // Send response
        var response = ReservationProto.AddClientResponse.newBuilder()
                .setMessage("Client added successfully: " + client.getNom())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void addChambre(ReservationProto.AddChambreRequest request,
                           StreamObserver<ReservationProto.AddChambreResponse> responseObserver) {
        // Extract chambre from request
        var grpcChambre = request.getChambre();

        // Map gRPC chambre to entity
        Chambre chambre = new Chambre();
        chambre.setType(grpcChambre.getType());
        chambre.setPrix(grpcChambre.getPrix());
        chambre.setDisponible(grpcChambre.getDisponible());

        // Save to database
        chambreRepository.save(chambre);

        // Send response
        var response = ReservationProto.AddChambreResponse.newBuilder()
                .setMessage("Chambre added successfully: " + chambre.getType())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}